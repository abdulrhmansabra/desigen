document.querySelectorAll('.nav a').forEach(a=>a.addEventListener('click',()=>{document.querySelectorAll('.nav a').forEach(x=>x.classList.remove('active'));a.classList.add('active')}));
document.querySelectorAll('.tab,.chip').forEach(el=>el.addEventListener('click',()=>{const p=el.parentElement;if(p){p.querySelectorAll('.tab,.chip').forEach(x=>x.classList.remove('active'));el.classList.add('active')}}));
document.querySelectorAll('.btn').forEach(b=>b.addEventListener('click',()=>{b.animate([{transform:'scale(1)'},{transform:'scale(.98)'},{transform:'scale(1)'}],{duration:150})}));


/* Reusable image input demo: select, preview, replace, remove, and drag/drop. */
document.querySelectorAll('[data-image-field]').forEach(field=>{
  const input=field.querySelector('.image-file-input');
  const frame=field.querySelector('.image-field-frame');
  const placeholder=field.querySelector('.image-placeholder');
  const preview=field.querySelector('.image-preview');
  const actions=field.querySelector('.image-file-actions');
  const fileName=field.querySelector('.image-file-name');
  const status=field.querySelector('.image-status');
  const choose=field.querySelector('.image-choose');
  const replace=field.querySelector('.image-replace');
  const remove=field.querySelector('.image-remove');
  let objectUrl=null;
  const reset=()=>{
    if(objectUrl){URL.revokeObjectURL(objectUrl);objectUrl=null}
    input.value='';
    preview.removeAttribute('src');
    preview.hidden=true;
    actions.hidden=true;
    placeholder.hidden=false;
    status.textContent='تم حذف الصورة. يمكنك اختيار صورة أخرى.';
    field.classList.remove('has-image');
  };
  const loadFile=file=>{
    if(!file)return;
    if(!/^image\/(png|jpeg|webp)$/.test(file.type)){
      status.textContent='نوع الملف غير مدعوم. اختر PNG أو JPG أو WEBP.';
      input.value='';
      return;
    }
    if(file.size>20*1024*1024){
      status.textContent='حجم الصورة أكبر من 20 MB. اختر ملفًا أصغر.';
      input.value='';
      return;
    }
    if(objectUrl)URL.revokeObjectURL(objectUrl);
    objectUrl=URL.createObjectURL(file);
    preview.src=objectUrl;
    preview.hidden=false;
    placeholder.hidden=true;
    actions.hidden=false;
    fileName.textContent=file.name;
    status.textContent='تم اختيار الصورة بنجاح.';
    field.classList.add('has-image');
  };
  choose?.addEventListener('click',()=>input.click());
  replace?.addEventListener('click',()=>input.click());
  remove?.addEventListener('click',reset);
  input?.addEventListener('change',()=>loadFile(input.files?.[0]));
  frame?.addEventListener('dragover',event=>{event.preventDefault();frame.classList.add('is-dragging')});
  frame?.addEventListener('dragleave',()=>frame.classList.remove('is-dragging'));
  frame?.addEventListener('drop',event=>{
    event.preventDefault();
    frame.classList.remove('is-dragging');
    loadFile(event.dataTransfer?.files?.[0]);
  });
});
/* Top-bar back control behaves naturally in a browser preview. */
document.querySelectorAll('.back-button').forEach(button=>button.addEventListener('click',()=>{
  if(window.history.length>1)window.history.back();
  else{
    const status=button.closest('.app-topbar-demo')?.nextElementSibling;
    if(status)status.textContent='لا توجد صفحة سابقة في المعاينة.';
  }
}));
