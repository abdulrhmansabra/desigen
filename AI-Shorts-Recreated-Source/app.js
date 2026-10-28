const promptField = document.querySelector("#prompt");
const counter = document.querySelector("#counter");
const notice = document.querySelector("#notice");

promptField.addEventListener("input", () => {
  counter.textContent = `${promptField.value.length.toLocaleString("en-US")} / 5000`;
});

document.querySelectorAll(".mode-tab").forEach((tab) => {
  tab.addEventListener("click", () => {
    document.querySelectorAll(".mode-tab").forEach((item) => {
      item.classList.remove("active");
      item.setAttribute("aria-pressed", "false");
    });
    tab.classList.add("active");
    tab.setAttribute("aria-pressed", "true");
    notice.textContent = `وضع المعاينة المحدد: ${tab.innerText.trim()} — واجهة تجريبية فقط.`;
  });
});

document.querySelectorAll(".reference-slot").forEach((slot) => {
  slot.addEventListener("click", () => {
    notice.textContent = `مكان المرجع ${slot.dataset.slot} محدد. رفع الملفات غير مفعّل في هذه النسخة.`;
    slot.animate(
      [{ transform: "scale(1)" }, { transform: "scale(.975)" }, { transform: "scale(1)" }],
      { duration: 220, easing: "ease-out" }
    );
  });
});

document.querySelector("#assistButton").addEventListener("click", () => {
  if (!promptField.value.trim()) {
    promptField.focus();
    notice.textContent = "اكتب وصفًا أولًا ليظهر هنا اقتراح تحسين الوصف.";
    return;
  }
  notice.textContent = "ميزة تحسين الوصف تحتاج إلى ربط خدمة ذكاء اصطناعي؛ لم يتم إرسال أي بيانات.";
});

document.querySelector("#createButton").addEventListener("click", () => {
  notice.textContent = promptField.value.trim()
    ? "تم التحقق من وجود وصف. إنشاء الفيديو غير متصل بخدمة فعلية في هذه النسخة."
    : "أضف وصفًا للمشهد قبل المتابعة. هذه الواجهة للمعاينة فقط.";
  if (!promptField.value.trim()) promptField.focus();
});

document.querySelector("#historyButton").addEventListener("click", () => {
  notice.textContent = "لا يوجد سجل محفوظ في النسخة التجريبية.";
});

document.querySelector("#modelMenu").addEventListener("click", () => {
  notice.textContent = "اختيار النماذج غير متصل بمزوّد فعلي في هذه النسخة.";
});
document.querySelector("#modelCard").addEventListener("click", () => {
  notice.textContent = "بطاقة Minimax H3 توضيحية؛ لم يتم ربط واجهة API.";
});