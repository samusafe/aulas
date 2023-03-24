const express  = require('express')
const router = express.Router()
const {getBarber, postBarber} = require('../controllers/barberController')

router.route('/').get(getBarber).post(postBarber)

/**
 * @swagger
 * /barbeiros/api/:id
 *  put:
 *      description: Atualiza o barbeiro
 *      parametros:
 *          nome: id
 *      response:
 *          '200':
 *              description: Atualizado com sucesso
 *  
 */

router.put('/api/:id', (req, res) => {
    console.log(req.params.id)
    res.status(200).json({message: `Recurso: ${req.params.id} atualizado com sucesso`})
})

module.exports = router
