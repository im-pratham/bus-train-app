const jsonServer = require('json-server')
const server = jsonServer.create()
const router = jsonServer.router('db.json')
const middlewares = jsonServer.defaults()

server.use(middlewares)

server.get('/canfail', (req, res) => {
  switch (Math.floor(Math.random() * 3)) {
    case 1:
      status = 500;
      message = "Error message here."
      break;
    case 2:
      status = 401;
      message = "You cannot enter here."
      break;
    default:
      status = 200;
      message = "Lucky you."
  }
    res.status(status).jsonp({
      message: `${message}`
    })
});

server.use(router)
server.listen(3000, () => {
  console.log('JSON Server is running')
})