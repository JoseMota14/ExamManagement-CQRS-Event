{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "type": "array",
  "items": {
    "type": "object",
    "properties": {
      "id": {
        "type": "integer"
      },
      "name": {
        "type": "string"
      }
    },
    "additionalProperties": true,
    "required": [
      "id",
      "name"
    ]
  },
  "additionalItems": true
}