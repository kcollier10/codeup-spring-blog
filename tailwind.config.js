module.exports = {
  purge: [],
  darkMode: false, // or 'media' or 'class'
  theme: {
    colors: {
      greenLime: '#64FF5C',
    },
    extend: {
      backgroundImage: theme => ({
        ... theme('user-images'),
        'blog-avatar': "url(/static/img/orange.jpg)"
      })
    },
  },
  variants: {
    extend: {},
  },
  plugins: [],
}
