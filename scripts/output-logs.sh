#!/bin/bash

# Definir directorio de salida y archivo de salida
OUTPUT_DIR="scripts"
OUTPUT_FILE="$OUTPUT_DIR/output-logs.txt"

# Crear la carpeta scripts si no existe
mkdir -p "$OUTPUT_DIR"

# Limpiar el archivo de salida si existe
> "$OUTPUT_FILE"

# Función para procesar archivos
procesar_archivos() {
    local folder="$1"
    find "$folder" -type d -name "target" -prune -o -type f -print | while read -r file; do
        echo "/***********/" >> "$OUTPUT_FILE"
        echo "Archivo: $file" >> "$OUTPUT_FILE"
        cat "$file" >> "$OUTPUT_FILE"
        echo -e "\n" >> "$OUTPUT_FILE"
    done
}

# if [ -d "api-gateway" ]; then
#     procesar_archivos "api-gateway"
# fi

# if [ -d "eureka-server" ]; then
#     procesar_archivos "eureka-server"
# fi

# if [ -d "product-service" ]; then
#     procesar_archivos "product-service"
# fi

# # Incluir archivos Docker si existen
# for file in pom.xml; do
#     if [ -f "$file" ]; then
#         echo "/***********/" >> "$OUTPUT_FILE"
#         echo "Archivo: $file" >> "$OUTPUT_FILE"
#         cat "$file" >> "$OUTPUT_FILE"
#         echo -e "\n" >> "$OUTPUT_FILE"
#     fi
# done

# Procesar archivos en curl-scripts
if [ -d "logs" ]; then
    procesar_archivos "logs"
fi

echo "✅ Procesamiento completado. Archivo generado en: $OUTPUT_FILE"
