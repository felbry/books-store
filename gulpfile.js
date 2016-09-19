var gulp = require('gulp'),
		sass = require('gulp-sass'),
		browserSync = require('browser-sync').create(),
		reload = browserSync.reload,
		notify = require('gulp-notify');

gulp.task('serve', ['scssToCss'], function() {

    browserSync.init({
        server: "./WebContent"
    });

    gulp.watch("WebContent/css/lib/*.scss", ['scssToCss']);
    gulp.watch("WebContent/*.html").on('change', reload);
		gulp.watch("WebContent/js/*.js").on('change', reload);
});

gulp.task('scssToCss', () => {
	gulp.src('./WebContent/css/lib/*.scss')
		.pipe(sass())
		.pipe(gulp.dest('./WebContent/css'))
		/*
		.pipe(notify({
			message: 'css has transformd successfully.'
		}))
		*/
		.pipe(reload({stream: true}));
});

gulp.task('default', ['serve']);
