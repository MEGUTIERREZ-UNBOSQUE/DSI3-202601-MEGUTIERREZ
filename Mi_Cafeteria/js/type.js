'use strict';

/* Loader */

function initLoader() {

  const loader = document.getElementById('page-loader');
  if (!loader) return;

  window.addEventListener('load', () => {

    setTimeout(() => {
      loader.classList.add('hidden');

      setTimeout(() => loader.remove(), 600);

    }, 600);

  });

}


/* Navbar */

function initNavbar() {

  const navbar    = document.getElementById('navbar');
  const hamburger = document.getElementById('hamburger');
  const nav       = navbar?.querySelector('.navbar__nav');

  if (!navbar) return;

  function onScroll() {
    navbar.classList.toggle('scrolled', window.scrollY > 60);
  }

  window.addEventListener('scroll', onScroll, { passive: true });
  onScroll();

  if (!hamburger || !nav) return;

  hamburger.addEventListener('click', () => {

    const isOpen = nav.classList.toggle('is-open');

    hamburger.setAttribute('aria-expanded', isOpen);

    document.body.style.overflow = isOpen ? 'hidden' : '';

  });

  nav.querySelectorAll('a').forEach(link => {

    link.addEventListener('click', () => {

      nav.classList.remove('is-open');
      document.body.style.overflow = '';

    });

  });

  document.addEventListener('click', (e) => {

    if (!navbar.contains(e.target) && nav.classList.contains('is-open')) {

      nav.classList.remove('is-open');
      document.body.style.overflow = '';

    }

  });

}


/* Scroll reveal */

function initScrollReveal() {

  const items = document.querySelectorAll(
    '.historia__text, .historia__visual, .product-card,' +
    '.testimonial-card, .newsletter__text, .newsletter__form,' +
    '.section-header, .experiencia__quote'
  );

  if (!items.length) return;

  items.forEach((el, i) => {

    el.classList.add('reveal');

    if (i % 3 === 1) el.classList.add('reveal-delay-1');
    if (i % 3 === 2) el.classList.add('reveal-delay-2');

  });

  const observer = new IntersectionObserver((entries) => {

    entries.forEach(entry => {

      if (!entry.isIntersecting) return;

      entry.target.classList.add('visible');

      observer.unobserve(entry.target);

    });

  }, { threshold: 0.12 });

  items.forEach(el => observer.observe(el));

}


/* Modal login */

function initModal() {

  const modal    = document.getElementById('loginModal');
  const openBtn  = document.getElementById('loginBtn');
  const closeBtn = document.getElementById('modalClose');
  const overlay  = document.getElementById('modalOverlay');

  if (!modal) return;

  const open  = () => modal.classList.add('is-open');
  const close = () => modal.classList.remove('is-open');

  openBtn?.addEventListener('click', open);
  closeBtn?.addEventListener('click', close);
  overlay?.addEventListener('click', close);

  document.addEventListener('keydown', (e) => {

    if (e.key === 'Escape') close();

  });

  const form = document.getElementById('loginForm');

  form?.addEventListener('submit', (e) => {

    e.preventDefault();

    const email = document.getElementById('loginEmail')?.value.trim();
    const pass  = document.getElementById('loginPassword')?.value;

    if (!email || !pass) return;

    const btn = form.querySelector('button');

    btn.textContent = 'Ingresando...';
    btn.disabled = true;

    setTimeout(() => {

      close();

      btn.textContent = 'Ingresar';
      btn.disabled = false;

      form.reset();

      showToast('Bienvenido');

    }, 1200);

  });

}


/* Registro */

function initRegisterForm() {

  const form = document.getElementById('registerForm');
  if (!form) return;

  const fields = {

    regName: {
      validate: v => v.trim().length >= 3 ? '' : 'Nombre mínimo 3 caracteres'
    },

    regEmail: {
      validate: v => /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(v) ? '' : 'Correo inválido'
    },

    regPass: {
      validate: v => v.length >= 8 ? '' : 'Mínimo 8 caracteres'
    },

    regPassConfirm: {
      validate: v => {
        const pass = document.getElementById('regPass').value;
        return v === pass ? '' : 'No coincide';
      }
    }

  };

  function validate(input, error, field) {

    const msg = field.validate(input.value);

    error.textContent = msg;

    input.classList.toggle('is-invalid', !!msg);
    input.classList.toggle('is-valid', !msg);

    return !msg;

  }

  Object.keys(fields).forEach(id => {

    const input = document.getElementById(id);
    const error = document.getElementById('err' + id.replace('reg',''));

    if (!input || !error) return;

    input.addEventListener('blur', () => validate(input, error, fields[id]));

    input.addEventListener('input', () => {

      if (input.classList.contains('is-invalid')) {

        validate(input, error, fields[id]);

      }

    });

  });

}


/* Language switch */

function initLangSwitch() {

  document.querySelectorAll('.lang-btn').forEach(btn => {

    btn.addEventListener('click', () => {

      document
        .querySelectorAll('.lang-btn')
        .forEach(b => b.classList.remove('lang-btn--active'));

      btn.classList.add('lang-btn--active');

    });

  });

}


/* Ripple */

function initRipple() {

  document.querySelectorAll('.btn').forEach(btn => {

    btn.addEventListener('click', (e) => {

      const rect = btn.getBoundingClientRect();

      const size = Math.max(rect.width, rect.height);

      const ripple = document.createElement('span');

      ripple.className = 'ripple';

      ripple.style.width  = size + 'px';
      ripple.style.height = size + 'px';

      ripple.style.left =
        (e.clientX - rect.left - size / 2) + 'px';

      ripple.style.top  =
        (e.clientY - rect.top - size / 2) + 'px';

      btn.appendChild(ripple);

      ripple.addEventListener('animationend', () => ripple.remove());

    });

  });

}


/* Parallax */

function initParallax() {

  const bg = document.querySelector('.hero__bg');
  if (!bg) return;

  window.addEventListener('scroll', () => {

    const y = window.scrollY;

    if (y < window.innerHeight) {

      bg.style.transform = `translateY(${y * 0.4}px)`;

    }

  }, { passive: true });

}


/* Toast */

function showToast(msg) {

  const toast = document.createElement('div');

  toast.className = 'toast';
  toast.textContent = msg;

  document.body.appendChild(toast);

  setTimeout(() => toast.remove(), 3000);

}


/* Smooth scroll */

function initSmoothAnchors() {

  document.querySelectorAll('a[href^="#"]').forEach(link => {

    link.addEventListener('click', (e) => {

      const id = link.getAttribute('href');
      const target = document.querySelector(id);

      if (!target) return;

      e.preventDefault();

      window.scrollTo({
        top: target.offsetTop - 80,
        behavior: 'smooth'
      });

    });

  });

}


/* Counter */

function initCounter() {

  const el = document.querySelector('.historia__badge-number');
  if (!el) return;

  const target = parseInt(el.textContent);

  let current = 0;

  const observer = new IntersectionObserver(([entry]) => {

    if (!entry.isIntersecting) return;

    observer.disconnect();

    const interval = setInterval(() => {

      current++;

      el.textContent = current;

      if (current >= target) {

        clearInterval(interval);

      }

    }, 40);

  });

  observer.observe(el);

}


/* Loader inject */

function injectLoader() {

  if (document.getElementById('page-loader')) return;

  const loader = document.createElement('div');

  loader.id = 'page-loader';

  loader.innerHTML = `
    <p class="loader__logo">Café De La Maison</p>
    <div class="loader__bar"></div>
  `;

  document.body.prepend(loader);

}


/* Init */

document.addEventListener('DOMContentLoaded', () => {

  injectLoader();
  initLoader();

  initNavbar();
  initScrollReveal();
  initModal();
  initRegisterForm();
  initLangSwitch();
  initRipple();
  initParallax();
  initSmoothAnchors();
  initCounter();

});