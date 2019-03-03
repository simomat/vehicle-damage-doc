module.exports = {
  outputDir: 'dist/static',
  assetsDir: 'static',
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8088',
        ws: true,
        changeOrigin: true
      }
    },
    open: true
  }
}
