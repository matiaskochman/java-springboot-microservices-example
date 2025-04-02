#!/bin/zsh

# Nombre del archivo: run-all.zsh

mkdir -p logs

echo "🚀 Iniciando Eureka Server..."
cd eureka-server
mvn spring-boot:run > ../logs/eureka-server.log 2>&1 &
EUREKA_PID=$!
cd ..

sleep 10 # Esperar a que Eureka se registre

# Configuración de escalabilidad
SCALE=${1#scale=}
SCALE=${SCALE:-1}

echo "🚀 Iniciando $SCALE instancia(s) de Product Service..."
for ((i=1; i<=$SCALE; i++))
do
  PORT=$((8089 + i))
  echo "📦 Instancia $i en puerto $PORT"
  cd product-service
  mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=$PORT --eureka.instance.instance-id=product-service-$i" > ../logs/product-service-$i.log 2>&1 &
  PRODUCT_PIDS+=" $!"
  cd ..
done

sleep $((5 * SCALE)) # Esperar registro escalado

echo "🌐 Iniciando API Gateway..."
cd api-gateway
mvn spring-boot:run > ../logs/api-gateway.log 2>&1 &
GATEWAY_PID=$!
cd ..

echo "✅ Todos los servicios fueron lanzados."
echo "📄 Logs guardados en la carpeta 'logs'"
echo "🛑 Para detenerlos: kill $EUREKA_PID $PRODUCT_PIDS $GATEWAY_PID"
