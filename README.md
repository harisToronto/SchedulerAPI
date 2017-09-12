# SchedulerAPISchedulerAPI

An API to provide scheduling services to other components

To clone:

git clone https://github.com/CityofToronto/schedulerAPI
To setup and run project:

From the root of the project:

mvn clean package spring-boot:run 
To create a new Schedule (In progress)

Create a JSON file some where on your drive with the following contents:

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
Request to POST:

curl -H "Content-Type: application/json" -X POST -d @/path_to_the_Json_file/create.json http://your_ip_address:8080/schedule/api/post 
