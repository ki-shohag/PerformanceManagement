const db = require('./db');

module.exports= {
	validate: function(user, callback){
		var sql = "SELECT * FROM `manager` WHERE email='"+user.email+"' AND password='"+user.password+"'";
		db.getResults(sql, function(results){
			if(results.length > 0){
				callback(true);
			}else{
				callback(false);
			}
		});
	},
	getByEmail: function(email, callback){
		var sql = "SELECT * FROM `manager` WHERE email='"+email+"'";
		db.getResults(sql, function(results){
			callback(results);
		});
	},
	getAssociates: function(id, callback){
		var sql = "SELECT c.id, m.id, cl.id FROM company as c LEFT JOIN manager as m on c.id=m.id LEFT JOIN clients as cl on m.id = cl.id WHERE cl.id = '"+id+"'";
		db.getResults(sql, function(results){
			callback(results);
		});
	},
	getById: function(id, callback){
		var sql = "select * from manager where id='"+id+"'";
		db.getResults(sql, function(results){
			callback(results);
		});
	},
	getAll: function(callback){
		var sql = "select * from manager";
		db.getResults(sql, function(results){
			callback(results);
		});
	},
	insert: function(user, callback){
		var sql = "INSERT INTO `manager`(`id`, `full_name`, `email`, `phone`, `dob`, `address`, `city`, `country`, `company_name`, `joining_date`, `user_name`, `password`, `status`) VALUES (0, '"+user.full_name+"', '"+user.email+"', '"+user.phone+"', '"+user.dob+"', '"+user.address+"', '"+user.city+"', '"+user.country+"', '"+user.company_name+"','"+user.joining_date+"', '"+user.user_name+"','"+user.password+"','"+user.status+"')";
		db.execute(sql, function(status){
			callback(status);
		});
	},
	update:function(sql, callback){
		console.log(sql);
		db.execute(sql, function(status){
			callback(status);
		});
	},
	delete: function(id, callback){
		var sql = "DELETE FROM `manager` WHERE id='"+id+"';";
		db.execute(sql, function(status){
			callback(status);
		});
	}
}