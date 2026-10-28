const promptField = document.getElementById('prompt');
const count = document.getElementById('count');

promptField.addEventListener('input', () => {
  count.textContent = promptField.value.length;
});

document.querySelectorAll('.tabs .tab').forEach((tab) => {
  tab.addEventListener('click', () => {
    document.querySelectorAll('.tabs .tab').forEach((item) => item.classList.remove('active'));
    tab.classList.add('active');
  });
});

document.querySelectorAll('.reference-card').forEach((card) => {
  card.addEventListener('click', () => {
    document.querySelectorAll('.reference-card').forEach((item) => item.classList.remove('selected'));
    card.classList.add('selected');
  });
});

document.getElementById('auto').addEventListener('click', () => {
  if (!promptField.value.trim()) {
    promptField.value = 'مشهد سينمائي واقعي، حركة كاميرا ناعمة، إضاءة درامية وتفاصيل عالية الجودة.';
    count.textContent = promptField.value.length;
  }
});

document.querySelector('.create').addEventListener('click', () => {
  if (!promptField.value.trim()) {
    promptField.focus();
    promptField.placeholder = 'اكتب وصف الفيديو الذي تريد إنشاءه أولاً...';
    return;
  }
  alert('هذه معاينة تصميم فقط؛ لم يتم ربطها بخدمة توليد فيديو.');
});
