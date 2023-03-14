const http = require('http')
const url = require('url')

const hostname = '127.0.0.1'
const port = 5000

const server = http.createServer((req, res) => {
    res.statusCode = 200
    if(req.url === '/about') {
        res.setHeader("Content-Type", "text/html")
        res.end('About page')
    }
    if(req.url === '/api') {
        res.setHeader("Content-Type", "text/html")
        res.end(JSON.stringify(1,3,54, "Jose"))
    }

    res.setHeader("Content-Type", "text/html")
    res.end('Voltei')
    var q = url.parse(req.url, true).query
    
    console.log(q)

    res.end('Hello world')
})

server.listen(port, hostname, ()=> {
    console.log(`Server running at http://${hostname}:${port}/`)
})