(() => {
  const promptField = document.querySelector("#prompt");
  const counter = document.querySelector("#char-count");
  const toast = document.querySelector("#toast");
  let toastTimer;
  let selectedMode = "all";
  let selectedRatio = 0;
  let selectedStyle = 0;
  const ratios = ["9:16", "16:9", "1:1"];
  const styles = ["واقعي", "سينمائي", "أنمي", "فني"];

  function showToast(message) {
    toast.textContent = message;
    toast.hidden = false;
    window.clearTimeout(toastTimer);
    toastTimer = window.setTimeout(() => { toast.hidden = true; }, 2800);
  }

  promptField.addEventListener("input", () => {
    counter.textContent = String(promptField.value.length);
  });

  document.querySelectorAll("[data-mode]").forEach((button) => {
    button.addEventListener("click", () => {
      selectedMode = button.dataset.mode;
      document.querySelectorAll("[data-mode]").forEach((item) => {
        const active = item === button;
        item.classList.toggle("is-active", active);
        item.setAttribute("aria-pressed", String(active));
      });
      if (selectedMode === "image") {
        showToast("وضع الصورة إلى فيديو محدد — هذه معاينة واجهة فقط.");
      } else if (selectedMode === "text") {
        showToast("وضع النص إلى فيديو محدد — هذه معاينة واجهة فقط.");
      } else {
        showToast("تم تحديد جميع الفيديو.");
      }
    });
  });

  document.querySelectorAll("[data-add-reference]").forEach((button) => {
    button.addEventListener("click", (event) => {
      event.stopPropagation();
      const card = button.closest(".upload-card");
      const count = Number(card.dataset.count || 1);
      showToast("مكان إضافة المرجع " + count + " جاهز في النموذج التوضيحي؛ رفع الملفات غير متصل.");
    });
  });

  document.querySelectorAll("[data-action]").forEach((button) => {
    button.addEventListener("click", () => {
      switch (button.dataset.action) {
        case "auto-prompt":
          if (!promptField.value.trim()) {
            promptField.value = "لقطة سينمائية لشخصية تسير وسط مشهد طبيعي عند الغروب، حركة كاميرا ناعمة، إضاءة وردية وبنفسجية، تفاصيل واقعية وانتقال سلس.";
          } else {
            promptField.value = promptField.value.trim() + "، حركة سينمائية ناعمة وإضاءة متوازنة وتفاصيل دقيقة.";
          }
          counter.textContent = String(promptField.value.length);
          promptField.focus();
          showToast("أُضيف اقتراح وصفي تجريبي إلى المطالبة.");
          break;
        case "ratio":
          selectedRatio = (selectedRatio + 1) % ratios.length;
          document.querySelector("#ratio-value").textContent = ratios[selectedRatio];
          showToast("نسبة العرض: " + ratios[selectedRatio]);
          break;
        case "style":
          selectedStyle = (selectedStyle + 1) % styles.length;
          document.querySelector("#style-value").textContent = styles[selectedStyle];
          showToast("الأسلوب: " + styles[selectedStyle]);
          break;
        case "credits":
          showToast("الرصيد المعروض توضيحي فقط.");
          break;
        case "model-menu":
        case "model-card":
          showToast("Minimax H3 — بيانات العرض توضيحية ولا يوجد اتصال بمزوّد نموذج.");
          break;
        case "upgrade":
          showToast("واجهة ترقية شكلية؛ لم يتم ربط الدفع أو الاشتراك.");
          break;
        case "advanced":
          showToast("الإعدادات المتقدمة غير موصولة في هذه النسخة المرئية.");
          break;
        case "back":
          showToast("زر الرجوع توضيحي داخل إعادة البناء.");
          break;
        case "create":
          if (!promptField.value.trim()) {
            showToast("أدخل وصفًا للمشهد أولًا. إنشاء الفيديو غير متصل في هذه المعاينة.");
            promptField.focus();
          } else {
            showToast("تم إعداد المعاينة محليًا فقط؛ لم يُنشأ ملف فيديو أو يُرسل أي طلب.");
          }
          break;
      }
    });
  });
})();
