module.exports = {
  purge: [],
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {
      backgroundImage: theme => ({
        ... theme('user-images'),
        'blog-avatar': "url(/src/main/resources/static/img/orange.jpg)"
      })
    },
  },
  variants: {
    extend: {},
  },
  plugins: [],
}
