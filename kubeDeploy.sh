#!/bin/sh

api=toy-robot
option=$1

if [ "${option}" == "build" ]
then
    echo "****************** Building Image  ******************"
    jar_file=`ls target/${api}*jar | cut -d'/' -f2`
		docker build -t ${api} --build-arg JAR_FILE=${jar_file} .

fi

if [ "${option}" == "deploy" ]
then
  echo "$(tput setaf 1)deploying ${api} service$(tput sgr0)"

  kubectl apply -f deployment.yml
	kubectl apply -f service.yml
fi