db.carro.insertOne({
  modelo: "Vectra",
  status: "DISPONIVEL",
  marca: "Chevrolet",
  placa: "GVA-4022",
  preco_diaria: 200,
});

db.carro.insertOne({
  modelo: "Pálio",
  status: "INDISPONIVEL",
  marca: "Fiat",
  placa: "HTL-8839",
  preco_diaria: 100,
});

db.carro.insertOne({
  modelo: "Onix",
  status: "DISPONIVEL",
  marca: "Chevrolet",
  placa: "IAI-1343",
  preco_diaria: 250,
});


db.carro.insertOne({
  modelo: "Elegance",
  status: "DISPONIVEL",
  marca: "Mercedes-Benz",
  placa: "NEX-1053",
  preco_diaria: 500,
});

db.clientes.insertMany([
    {
        id_usuario: 1,
        nome: 'Paulo Ricardo',
        data_nascimento: new Date(1986, 08, 12),
        cpf: '11111111111',
        telefone: '61999999999',
        email: 'paulor@teste.com'
    },
    {
        id_usuario: 2,
        nome: 'Grasi',
        data_nascimento: new Date(1989, 02, 09),
        cpf: '22222222222',
        telefone: '61888888888',
        email: 'grasi@teste.com'
    },
    {
        id_usuario: 3,
        nome: 'João Gabriel',
        data_nascimento: new Date(2017, 01, 31),
        cpf: '33333333333',
        telefone: '61777777777',
        email: 'jg@teste.com'
    },
    {
        id_usuario: 4,
        nome: 'Francisco Jose',
        data_nascimento: new Date(1990, 10, 04),
        cpf: '44444444444',
        telefone: '61666666666',
        email: 'francisco@teste.com'
    },
    {
        id_usuario: 5,
        nome: 'Ester Maria',
        data_nascimento: new Date(2020, 09, 14),
        cpf: '55555555555',
        telefone: '61555555555',
        email: 'ester@teste.com'
    }
])
{ acknowledged: true,
    insertedIds: 
       { '0': ObjectId("62ed07ce36f96b83a9de6e44"),
         '1': ObjectId("62ed07ce36f96b83a9de6e45"),
         '2': ObjectId("62ed07ce36f96b83a9de6e46"),
         '3': ObjectId("62ed07ce36f96b83a9de6e47"),
         '4': ObjectId("62ed07ce36f96b83a9de6e48") } }

-------------------------------------------------

------- Find
db.carro.find({
    preco_diaria : { $gt : 200 },
    preco_diaria : { $lt : 350 }
})
{ _id: ObjectId("62eb14b77643790f26128008"),
  modelo: 'Vectra',
  status: 'DISPONIVEL',
  marca: 'Chevrolet',
  placa: 'GVA-4022',
  preco_diaria: 200 }
{ _id: ObjectId("62eb16ad7643790f26128009"),
  modelo: 'Pálio',
  status: 'INDISPONIVEL',
  marca: 'Fiat',
  placa: 'HTL-8839',
  preco_diaria: 100 }
{ _id: ObjectId("62eb16d37643790f2612800a"),
  modelo: 'Ford Ka',
  status: 'DISPONIVEL',
  marca: 'Chevrolet',
  placa: 'IAI-1343',
  preco_diaria: 250 }
  
  db.clientes.find({cpf: "55555555555"})
{ _id: ObjectId("62ed07ce36f96b83a9de6e48"),
  id_usuario: 5,
  nome: 'Ester Maria',
  data_nascimento: 2020-10-14T03:00:00.000Z,
  cpf: '55555555555',
  telefone: '61555555555',
  email: 'ester@teste.com' }

  db.carro.find ({
    "marca":"Chevrolet"
  })
  { _id: ObjectId("62eb14b77643790f26128008"),
    modelo: 'Vectra',
    status: 'DISPONIVEL',
    marca: 'Chevrolet',
    placa: 'GVA-4022',
    preco_diaria: 200 }
  { _id: ObjectId("62eb16d37643790f2612800a"),
    modelo: 'Onix',
    status: 'DISPONIVEL',
    marca: 'Chevrolet',
    placa: 'IAI-1343',
    preco_diaria: 250 }

db.carro.findOne({
    "status":"INDISPONIVEL"
})
{ _id: ObjectId("62eb16ad7643790f26128009"),
    modelo: 'Pálio',
    status: 'INDISPONIVEL',
    marca: 'Fiat',
    placa: 'HTL-8839',
    preco_diaria: 100 }

db.carro.find({
    $or : [
        {"preco_diaria" : 200},
        {"preco_diaria" : 500}    
        ]
    })
{ _id: ObjectId("62eb14b77643790f26128008"),
    modelo: 'Vectra',
    status: 'DISPONIVEL',
    marca: 'Chevrolet',
    placa: 'GVA-4022',
    preco_diaria: 200 }
{ _id: ObjectId("62eb17627643790f2612800c"),
    modelo: 'Elegance',
    status: 'DISPONIVEL',
    marca: 'Mercedes-Benz',
    placa: 'NEX-1053',
    preco_diaria: 500 }

  ----------------- Delete
  db.clientes.deleteOne({nome: "Francisco José"})
{ acknowledged: true, deletedCount: 0 }

db.carro.deleteMany(
    {preco_diaria : { $lt : 200 }})
  { acknowledged: true, deletedCount: 1 }

  ------------Update
  db.carro.updateOne(
    {modelo: 'Ford Ka'},
    {$set:{modelo: 'Onix'}
})
{ acknowledged: true,
  insertedId: null,
  matchedCount: 1,
  modifiedCount: 1,
  upsertedCount: 0 }

  db.clientes.updateOne(
    {nome:"Paulo Ricardo"},
    {
      $set: {"nome":"Paulo", cpf:"99999999999"}
    })
  { acknowledged: true,
    insertedId: null,
    matchedCount: 1,
    modifiedCount: 1,
    upsertedCount: 0 }