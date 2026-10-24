// SABRA UI Interactive Logic
document.addEventListener('DOMContentLoaded', () => {
    // Initialize Lucide Icons
    if (typeof lucide !== 'undefined') {
        lucide.createIcons();
    }

    // Tab Switching Logic for Segmented Controls
    const segmentedGroups = document.querySelectorAll('.sabra-segmented');
    segmentedGroups.forEach(group => {
        const buttons = group.querySelectorAll('.sabra-segmented-btn');
        buttons.forEach(btn => {
            btn.addEventListener('click', () => {
                buttons.forEach(b => b.classList.remove('active'));
                btn.classList.add('active');
            });
        });
    });

    // Code Copy Toast Functionality
    window.copyCodeSnippet = function(elementId) {
        const codeText = document.getElementById(elementId).innerText;
        navigator.clipboard.writeText(codeText).then(() => {
            showToast('تم نسخ الكود بنجاح!');
        });
    };

    function showToast(message) {
        const toast = document.createElement('div');
        toast.className = 'fixed bottom-6 right-6 bg-purple-600 text-white px-4 py-2.5 rounded-xl text-xs font-semibold shadow-2xl z-50 transition-all transform translate-y-2 opacity-0';
        toast.innerText = message;
        document.body.appendChild(toast);
        
        setTimeout(() => {
            toast.classList.remove('translate-y-2', 'opacity-0');
        }, 50);

        setTimeout(() => {
            toast.classList.add('translate-y-2', 'opacity-0');
            setTimeout(() => toast.remove(), 300);
        }, 2500);
    }
});
