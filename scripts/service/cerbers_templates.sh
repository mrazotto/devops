#! /bin/bash

blserver_config="blserver/config/application.properties"

propName=""
propValue=""
propAnsName=""

mkdir -p cerbers_templates/blserver/config

for item in $(cat $blserver_config | tr -d ' ')
do
    if [[ $item == *"="* ]] && [[ $item != *"#"* ]]
    then
        propName=`echo $item | cut -d '=' -f 1`
        propValue=`echo $item | cut -d '=' -f 2`
        propAnsName=`echo $propName | sed 's/[-|.]/_/g'`

        echo $propName | { tr -d '\n' ; echo "={% if $propAnsName is defined %}{{$propAnsName}}{% else %}$propValue{% endif %}"; } \
            >> ./cerbers_templates/blserver/config/application.properties.j2
        echo >> ./cerbers_templates/blserver/config/application.properties.j2
    fi
done
