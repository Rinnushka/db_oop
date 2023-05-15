
function confirmDeleted(e) {
	if (confirm('Удаление нельзя отменить! Удалить?')) {
	return true;
	} else {
	e.preventDefault();
	}
}