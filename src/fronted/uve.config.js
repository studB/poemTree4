module.exports = {
    devServer: {
        proxy: {
            '/': {
                target: 'http://localhost:8001',
                ws: true,
                changeOrigin: true
            }
        }
    }
}