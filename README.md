# SchedulerAPI

An API to provide scheduling services to other components

## Pre-requisites:
1. MySql 5, Ideally 5.44
2. MySql Workbench

## To clone:

`git clone https://github.com/CityofToronto/schedulerAPI`

## To setup and run project:

From the root of the project:

1. Import project inside eclipse
2. Right click on the Project --> Configure --> Add Gradle nature
3. Right click on the project --> Gradle --> Refresh gradle project
4. Refresh your project
5. For now, the project uses MySQL, so make sure you have downloaded and installed mysql and know the root username and password
6. Make sure to update application.properties file and change 'spring.datasource.username' and 'spring.datasource.password' to reflect the mysql user (if you created a separate user to be used for this API) or admin user.
7. Add or remove to Liberty and start server. Make sure there are no errors on the console
8. Inside MySql workbench, make sure you have a schema by the name of 'schedulerApi' created and the tables have been generated.

## To create a new Schedule (In progress)

Create a JSON file some where on your drive with the following contents:
```
{
	"schedule": {
		"type": "recurring",
		"enabled": true,
		"endPointUrl": "http://fodaboda.com/endpoint",
		"recurrence": {
			"frequency": "days",
			"interval": 1,
			"startTime": "2017-08-31T05:00:00",
			"endTime": 2,
			"runTimes": [
				{
					"time": "22:00"
				}
			]
		}
	},
	"params": {
		"deltaParams": {
			"aggrPeriod": "M",
			"rangeUnits": 1,
			"rangePeriod": "months",
			"executionTime": 1
		},
		"target": {
			"targetType": "s3",
			"outputFormat": "csv"
		}
	}
}
```

## Request to POST:

`curl -H "Content-Type: application/json" -X POST -d @/path_to_the_Json_file/create.json http://your_ip_address:9080/schedule/api/post` 

**Make sure to checkout the EAR project for your Liberty server as well: https://github.com/harisToronto/SchedulerAPIEAR**
