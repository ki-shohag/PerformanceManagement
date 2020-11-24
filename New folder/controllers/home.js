const express 	= require('express');
const router 	= express.Router();
const managerModel		= require.main.require('./models/managerModel');

router.get('/', (req, res)=>{
	res.render('home/index',{
		full_name: null
	});
});

module.exports = router;