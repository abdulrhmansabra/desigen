document.querySelectorAll('.nav a').forEach(a=>a.addEventListener('click',()=>{document.querySelectorAll('.nav a').forEach(x=>x.classList.remove('active'));a.classList.add('active')}));
document.querySelectorAll('.tab,.chip').forEach(el=>el.addEventListener('click',()=>{const p=el.parentElement;if(p){p.querySelectorAll('.tab,.chip').forEach(x=>x.classList.remove('active'));el.classList.add('active')}}));
document.querySelectorAll('.btn').forEach(b=>b.addEventListener('click',()=>{b.animate([{transform:'scale(1)'},{transform:'scale(.98)'},{transform:'scale(1)'}],{duration:150})}));
