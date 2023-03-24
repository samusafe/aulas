const express = require('express');
let PlayerAPI = require('./server/players');

function initialize() {
    let api = express();

    api.use('/', PlayerAPI());

    return api;
}

module.exports = {
    initialize: initialize,
};