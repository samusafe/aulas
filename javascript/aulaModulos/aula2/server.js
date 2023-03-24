const express = require('express')
const dotenv = require('dotenv').config()
const swaggerUI = require('swagger-ui-express')
const swaggerJSDoc = require('swagger-jsdoc')

const port = process.env.PORT || 7000
const app = express()

const swaggerOptions = {
    swaggerDefinition: {
        info: {
            title: 'Swagger UI',
            version: '1.0.0',
            description: 'Exemplo API aula 4',
        },
    },
    apis: ['./routes/barberRoutes.js']
};

const swaggerDocs = swaggerJSDOC(swaggerOptions)
app.use('/api.docs', swaggerUI.server, swaggerUI.setup(swaggerDocs))

app.use(express.json())
app.use(express.urlencoded({extended: false}))
app.use('/barbeiros', require('./routes/barberRoutes'))

app.listen(port, () => {
    console.log(`Server running on port ${port}`)
})

