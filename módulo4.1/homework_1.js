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
  modelo: "Compass",
  status: "INDISPONIVEL",
  marca: "Jepp",
  placa: "NEZ-5353",
  preco_diaria: 350,
});

db.carro.insertOne({
  modelo: "Elegance",
  status: "DISPONIVEL",
  marca: "Mercedes-Benz",
  placa: "NEX-1053",
  preco_diaria: 500,
});

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

db.carro.update(
    {modelo: 'Onix'},
    {$set:{modelo: 'Ford Ka'}
})

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
