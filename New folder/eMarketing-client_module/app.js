//declaration
const express 			= require('express');
const bodyParser 		= require('body-parser');
const exSession 		= require('express-session');
const cookieParser 		= require('cookie-parser');
const app				= express();
const port				= 3001;

const home				= require('./controllers/clientUser/home');
const login				= require('./controllers/clientUser/login');
const logout			= require('./controllers/clientUser/logout');
const registration		= require('./controllers/clientUser/registration');
const client			= require('./controllers/clientUser/client');
const company			= require('./controllers/clientUser/company');
const companylist		= require('./controllers/clientUser/companylist');

//configuration
app.set('view engine', 'ejs');

//middleware
app.use('/assets', express.static('assets'));
app.use(bodyParser.urlencoded({extended: true}));
app.use(cookieParser());
app.use(exSession({secret: 'secret value', saveUninitialized: true, resave: false}));

app.use('/home', home);
app.use('/login', login);
app.use('/logout', logout);
app.use('/registration', registration);
app.use('/client', client);
app.use('/client/company', company);
app.use('/companylist', companylist);

//router
app.get('/', (req, res)=>{
	res.send('Welcome');
});

//server startup
app.listen(port, (error)=>{
	console.log('server strated at '+port);
});