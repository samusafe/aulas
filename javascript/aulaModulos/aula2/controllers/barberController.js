const getBarber = (req, res) => {
    res.status(201).json({nome: 'Jose Pedro', nacionalidade: 'PT'})
    //res.send("Hello world")
}

const postBarber = (req,res) => {
    console.log(req.body)
    res.status(201).json({message: "Recurso criado com sucesso"})
}

module.exports = {
    getBarber,
    postBarber
}