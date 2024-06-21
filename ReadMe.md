# Product Micro Service

## Endpoints
- BaseURL: /products
- POST: create()
- GET: getAll()
- GET /{id} : getById()
- PUT /{id} : updateById()
- DELETE /{id} : delete()

## Model
```json
{
  "id": 1,
  "name": "iPhone 13 Pro Max",
  "description": "Celular Top",
  "price": 6999.90,
  "isAvailable": true
}
```

## Business Rules
- Proibida a criação de produtos com preço negativo
- Não é possível pesquisar produtos que não estão disponíveis
- Não é possível inserir descrições com menos do que 50 caracteres

