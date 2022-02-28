# spring-boot-mongodb coding test.

**How to run application**
1. Download coding test application from repository.
2. Open application in the editor of your choice (eclipse / Intellej)
3. Run *mvn clean install* from root directory of the application.
4. Run *mvn spring-boot:run* to start the server. Application uses embedded mongodb, make sure you wait for mongodb to initialize.

(Alternatively, if you have STS toolkit installed in IDE, you can run application as springboot from IDE)


**What to do ?**

Coding test application allows CRUD operations on hypothetical noun called Product. However, not all methods have been implemented. You are required to perform following tasks.

- ProductBean does not validate user inputs. Apply following validations on ProductBean
   - ProductId must not be null and should allow numbers only.
   - ProductCode can not be empty.
   - ProductPrice should only allow float values only with two decimal precision.
   
- Implement the method /product/sort to return product data sorted on product name. (Note: that application automatically inserts bunch of product records automatically on startup)

- Implement method deleteProduct so that the product with specific id is removed from database.

- Add junit tests for any two methods in ProductOperationsImpl class.



**Postman Collection**

Import this collection in postman for quick test.

```{
	"info": {
		"_postman_id": "bc11ccd5-b348-4663-98ed-04e3bf5e4ae5",
		"name": "create-product",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "Product",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"id\":\"123\",\n    \"productCode\":\"1120RD\",\n    \"productBrand\":\"1001\",\n    \"productName\":\"Floral Embrace\",\n    \"productDescription\":\"Each arrangement is uniquely crafted by a local florist using the freshest blooms available regionally. While there may be some variations from the photo shown.\",\n    \"imageUrl\":\"https://cdn3.1800flowers.com/wcsstore/Flowers/imag…height=597&quality=80&auto=webp&optimize={medium}\",\n    \"productPrice\":20.99\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/codingtest/product",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"codingtest",
						"product"
					]
				}
			},
			"response": []
		},
		{
			"name": "FindByProductId",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"id\":\"123\",\n    \"productCode\":\"1120RD\",\n    \"productBrand\":\"1001\",\n    \"productName\":\"Floral Embrace\",\n    \"productDescription\":\"Each arrangement is uniquely crafted by a local florist using the freshest blooms available regionally. While there may be some variations from the photo shown.\",\n    \"imageUrl\":\"https://cdn3.1800flowers.com/wcsstore/Flowers/imag…height=597&quality=80&auto=webp&optimize={medium}\",\n    \"productPrice\":20.99\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/codingtest/product/123",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"codingtest",
						"product",
						"123"
					]
				}
			},
			"response": []
		},
		{
			"name": "FindAllProducts",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"id\":\"123\",\n    \"productCode\":\"1120RD\",\n    \"productBrand\":\"1001\",\n    \"productName\":\"Floral Embrace\",\n    \"productDescription\":\"Each arrangement is uniquely crafted by a local florist using the freshest blooms available regionally. While there may be some variations from the photo shown.\",\n    \"imageUrl\":\"https://cdn3.1800flowers.com/wcsstore/Flowers/imag…height=597&quality=80&auto=webp&optimize={medium}\",\n    \"productPrice\":20.99\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/codingtest/product/all",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"codingtest",
						"product",
						"all"
					]
				}
			},
			"response": []
		},
		{
			"name": "FindAllProductsSorted",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"id\":\"123\",\n    \"productCode\":\"1120RD\",\n    \"productBrand\":\"1001\",\n    \"productName\":\"Floral Embrace\",\n    \"productDescription\":\"Each arrangement is uniquely crafted by a local florist using the freshest blooms available regionally. While there may be some variations from the photo shown.\",\n    \"imageUrl\":\"https://cdn3.1800flowers.com/wcsstore/Flowers/imag…height=597&quality=80&auto=webp&optimize={medium}\",\n    \"productPrice\":20.99\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/codingtest/product/sort",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"codingtest",
						"product",
						"sort"
					]
				}
			},
			"response": []
		},
		{
			"name": "RemoveProductById",
			"request": {
				"method": "DELETE",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"id\":\"123\",\n    \"productCode\":\"1120RD\",\n    \"productBrand\":\"1001\",\n    \"productName\":\"Floral Embrace\",\n    \"productDescription\":\"Each arrangement is uniquely crafted by a local florist using the freshest blooms available regionally. While there may be some variations from the photo shown.\",\n    \"imageUrl\":\"https://cdn3.1800flowers.com/wcsstore/Flowers/imag…height=597&quality=80&auto=webp&optimize={medium}\",\n    \"productPrice\":20.99\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/codingtest/product/",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"codingtest",
						"product",
						""
					]
				}
			},
			"response": []
		}
	]
}```

