var mealAjaxUrl = "ajax/profile/meals/";
function updateFilteredTable() {
	$.ajax({
		type: "GET",
		url: `${mealAjaxUrl}filter`,
		data: $("#filter").serialize()
	}).done(updateTableByData);
}

function clearFilter() {
	$("#filter")[0].reset();
	$.get(mealAjaxUrl, updateTableByData);
}

$(function () {
	makeEditable({
		ajaxUrl: mealAjaxUrl,
		datatableApi: $("#datatable").DataTable({
			"ajax": {
				"url": mealAjaxUrl,
				"dataSrc": ""
			},
			"paging": false,
			"info": true,
			"columns": [
				{
					"data": "dateTime",
					render: function (data, type, full, meta) {
						if (type === 'display') {
							let rowClass;
							if (full.excess) {
								rowClass = 'red';
							} else {
								rowClass = 'green';
							}
							var rowIndex = meta.row + 1;
							$('#datatable tbody tr:nth-child(' + rowIndex + ')').addClass(rowClass);
							return data;
						} else {
							return data;
						}
					}
				},
				{
					"data": "description"
				},
				{
					"data": "calories"
				},
				{
					"orderable": false,
					"defaultContent": "",
					"render": renderEditBtn
				},
				{
					"orderable": false,
					"defaultContent": "",
					"render": renderDeleteBtn
				}
			],
			"order": [
				[
					0,
					"desc"
				]
			]
		}),
		updateTable: updateFilteredTable
	});
});
