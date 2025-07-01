document.querySelectorAll('[data-role="A"]').forEach(link => {
    link.addEventListener('click',function() {
        location.href = 'index2.html';
    });
});
