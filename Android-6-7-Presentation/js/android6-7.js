Reveal.initialize({
    controls: true,
    progress: true,
    history: true,
    slideNumber: true,
    center: true,
    transition: 'convex',
    width: 1080,

    dependencies: [{
        src: 'node_modules/reveal.js/lib/js/classList.js',
        condition: function () {
            return !document.body.classList;
        }
    }, {
        src: 'node_modules/reveal.js/plugin/markdown/marked.js',
        condition: function () {
            return !!document.querySelector('[data-markdown]');
        }
    }, {
        src: 'node_modules/reveal.js/plugin/markdown/markdown.js',
        condition: function () {
            return !!document.querySelector('[data-markdown]');
        }
    }, {
        src: 'node_modules/reveal.js/plugin/highlight/highlight.js',
        async: true,
        callback: function () {
            hljs.initHighlightingOnLoad();
        }
    }, {
        src: 'node_modules/reveal.js/plugin/zoom-js/zoom.js',
        async: true,
        condition: function () {
            return !!document.body.classList;
        }
    }, {
        src: 'node_modules/reveal.js/plugin/notes/notes.js',
        async: true,
        condition: function () {
            return !!document.body.classList;
        }
    }]
});

Reveal.addEventListener('slidechanged', function (event) {
    var video = event.currentSlide.getElementsByTagName('video');

    if(video && video[0]) {
        video[0].play();
    }

    if(event.previousSlide) {
        var lastVideo = event.previousSlide.getElementsByTagName('video');

        if (lastVideo && lastVideo[0]) {
            lastVideo[0].pause();
        }
    }
});

