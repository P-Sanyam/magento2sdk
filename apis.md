# Magento2 SDK API Reference

## Base URL
```
http://localhost:8080/api/v1
```

---

## Products API

### Create Product
```
POST /magento2/products/create
```

### Push Products (Bulk Upsert)
```
POST /magento2/products/push
```

---

## Customers API

### Create Customer
```
POST /magento2/customers/create
```

### Get Customer by ID
```
GET /magento2/customers/{customerId}
```

### Search Customers by Email
```
GET /magento2/customers/search?email=foo@bar.com
```
