#USE CASES

####1)
| USE CASE 1            | Produce a population report of all countries in the world  |
|-----------------------|-----|
| Goal in Context       |   As a software developer I want to create a country report with all the countries in the world, organised from largest populated to smallest populated, to provide the organisation with easy access to population information. |
| Scope & Level         | Company, Primary Task   |
| Preconditions         | Connection to the database   |
| Success End Condition | Complete report created on all countries in the world organised from largest populated to smallest populated. |
| Failed End Condition  | No report is produced.   |
| Primary Actor         | Company employee.   |
| Trigger               | A request for population information is made.   |

| DESCRIPTION   | STEP | ACTION           |
|---------------|------|------------------|
|               | 1    |      Request for population information is made            |
|               | 2    |      Connect to database            |
|               | 3    |      Report is produced            |
| EXTENSIONS    | Step | Branching Action |
|               |      | No Extensions    |
| SUBVARIATIONS |      | Branching Action |
|               |      |    None          |

| RELATED INFORMATION                    |   |
|----------------------------------------|---|
| Priority                               | 1   |
| Performance                            |  Deer (1 minute) |
| Frequency                              |  Once |
| Channels to actors                     |   Population database. |
| OPEN ISSUES                            |  Database doesn't connect. |
| Due Date                               | Release 1.0  |

####2)

| USE CASE 2            | Produce a population report of all countries in a continent  |
|-----------------------|-----|
| Goal in Context       |   As a software developer I want to create a country report with all the countries in a continent, organised from largest populated to smallest populated, to provide the organisation with easy access to population information. |
| Scope & Level         | Company, Primary Task   |
| Preconditions         | Connection to the database   |
| Success End Condition | Complete report created on all countries in a region organised from largest populated to smallest populated. |
| Failed End Condition  | No report is produced.   |
| Primary Actor         | Company employee.   |
| Trigger               | A request for population information is made.   |

| DESCRIPTION   | STEP | ACTION           |
|---------------|------|------------------|
|               | 1    |      Request for population information is made            |
|               | 2    |      Connect to database            |
|               | 3    |      Report is produced            |
| EXTENSIONS    | Step | Branching Action |
|               |      | No Extensions    |
| SUBVARIATIONS |      | Branching Action |
|               |      |    None          |

| RELATED INFORMATION                    |   |
|----------------------------------------|---|
| Priority                               | 1   |
| Performance                            |  Deer (1 minute) |
| Frequency                              |  Once |
| Channels to actors                     |   Population database. |
| OPEN ISSUES                            |  Database doesn't connect. |
| Due Date                               | Release 1.0  |

####3)

| USE CASE 3            | Produce a population report of all countries in a region  |
|-----------------------|-----|
| Goal in Context       |   As a software developer I want to create a country report with all the countries in a region, organised from largest populated to smallest populated, to provide the organisation with easy access to population information. |
| Scope & Level         | Company, Primary Task   |
| Preconditions         | Connection to the database   |
| Success End Condition | Complete report created on all countries in a region organised from largest populated to smallest populated. |
| Failed End Condition  | No report is produced.   |
| Primary Actor         | Company employee.   |
| Trigger               | A request for population information is made.   |

| DESCRIPTION   | STEP | ACTION           |
|---------------|------|------------------|
|               | 1    |      Request for population information is made            |
|               | 2    |      Connect to database            |
|               | 3    |      Report is produced            |
| EXTENSIONS    | Step | Branching Action |
|               |      | No Extensions    |
| SUBVARIATIONS |      | Branching Action |
|               |      |    None          |

| RELATED INFORMATION                    |   |
|----------------------------------------|---|
| Priority                               | 1   |
| Performance                            |  Deer (1 minute) |
| Frequency                              |  Once |
| Channels to actors                     |   Population database. |
| OPEN ISSUES                            |  Database doesn't connect. |
| Due Date                               | Release 1.0  |

####7)

| USE CASE 7                           | City report                                                                                                                                                                                                       |
|--------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Goal in Context                      | As a software developer I want to create a city report with all the cities in the world, organised from largest populated to smallest populated, to provide the organisation with easy access to population information. |
| Scope & Level                        | Company, Primary Task                                                                                                                                                                                             |
| Preconditions                        | A functioning SQL database.                                                                                                                                                                                       |
| Success End Condition                | A new Table which shows all the cities sorted by population ASC.                                                                                                                                                  |
| Failed End Condition                 | Inccorrect report generated, or no reported generated at all.                                                                                                                                                     |
| Primary, Secondary Actors            | Primary Actor, Company employee                                                                                                                                                                                   |
| Trigger                              | User requested city report                                                                                                                                                                                        |
| DESCRIPTION                          | STEP                                                                                                                                                                                                              | ACTION           |
| ---------------                      | ------                                                                                                                                                                                                            |------------------|
| Request for city report made         | 1                                                                                                                                                                                                                 |                  |
| Connect to database                  | 2                                                                                                                                                                                                                 |                  |
| Create new table and display to user | 3                                                                                                                                                                                                                 |                  |
| EXTENSIONS                           | Step                                                                                                                                                                                                              | Branching Action |
| No extensions                        | 1a                                                                                                                                                                                                                |                  |
| SUBVARIATIONS                        | None                                                                                                                                                                                                              | Branching Action |                                                                                                                                                                                                                   |                  |

| RELATED INFORMATION                    |                           |
|----------------------------------------|---------------------------|
| Priority                               | Top                       |
| Performance                            | Deer                      |
| Frequency                              | Once                      |
| Channels to actors                     | Static Files              |
| OPEN ISSUES                            | Database fails to connect |
| Due Date                               | Release 1.0               |
| ...Any other management information... |                           |
| Superordinates                         |                           |
| Subordinates                           |                           |

####8)

| USE CASE 8                                                          | City report - continent                                                                                                                                                                                                   |
|---------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Goal in Context                                                     | As a software developer I want to create a city report with all the cities in a continent, organised from largest populated to smallest populated, to provide the organisation with easy access to population information. |
| Scope & Level                                                       | Company, Primary Task                                                                                                                                                                                                     |
| Preconditions                                                       | A functioning SQL database.                                                                                                                                                                                               |
| Success End Condition                                               | A new Table which shows all the cities in a specifed contintent sorted by population ASC.                                                                                                                                 |
| Failed End Condition                                                | Inccorrect report generated, or no reported generated at all.                                                                                                                                                             |
| Primary, Secondary Actors                                           | Primary Actor, Company employee                                                                                                                                                                                           |
| Trigger                                                             | User requested city report                                                                                                                                                                                                |
| DESCRIPTION                                                         | STEP                                                                                                                                                                                                                      | ACTION           |
| ---------------                                                     | ------                                                                                                                                                                                                                    |------------------|
| Request for city report made                                        | 1                                                                                                                                                                                                                         |                  |
| Prompt user for continent                                           | 2                                                                                                                                                                                                                         |                  |
| Create new table with the said continent and sort by population ASC | 3                                                                                                                                                                                                                         |                  |
| EXTENSIONS                                                          | Step                                                                                                                                                                                                                      | Branching Action |
| No extensions                                                       | 1a                                                                                                                                                                                                                        |                  |
| SUBVARIATIONS                                                       | None                                                                                                                                                                                                                      | Branching Action |                                                                                                                                                                                                                   |                  |

| RELATED INFORMATION                    |                          |
|----------------------------------------|--------------------------|
| Priority                               | Top                      |
| Performance                            | Hippo                    |
| Frequency                              | Once                     |
| Channels to actors                     | Interactive database     |
| OPEN ISSUES                            | Database fails to connect |
| Due Date                               | Release 1.0              |
| ...Any other management information... |                          |
| Superordinates                         |                          |
| Subordinates                           |                          |

####9)

| USE CASE 9            | Create a report of cities in a region                                                                                                               |
|-----------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| Goal in Context       | Create a city report with all the cities in a region to smallest populated, to provide the organisation with easy access to population information. |
| Scope & Level         | Company, Primary function                                                                                                                           |
| Preconditions         | Database to be operative and connected.                                                                                                             |
| Success End Condition | Report of cities in a region from largest to smallest populated generated.                                                                          |
| Failed End Condition  | None report generated or an incorrect one.                                                                                                          |
| Primary Actors        | Organisation system user                                                                                                                            |
| Trigger               | Request the report from the database.                                                                                                               |

| DESCRIPTION   | STEP | ACTION                                                |
|---------------|---|-------------------------------------------------------|
|               | 1 | Request for population and cities information is made |
|               | 2 | Connect to database                                   |
|               | 3 | Report is produced                                    |
| EXTENSIONS    | Step | Branching Action                                      |
|               |   | No Extensions                                         |
| SUBVARIATIONS |   | Branching Action                                      |
|               | 1 | None                                                  |

| RELATED INFORMATION                    | 9. Create a report of cities in a region    |
|----------------------------------------|---------------------------------|
| Priority                               | 1                               |
| Performance                            | Deer (1 minute)                 |
| Frequency                              | Once                            |
| Channels to actors                     | Population and cities database. |
| OPEN ISSUES                            | Database doesn't connect.       |
| Due Date                               | Release 1.0                     |

####10)

| USE CASE 10               | Create a city report with all the cities in a country                                                         |
|---------------------------|---------------------------------------------------------------------------------------------------------------|
| Goal in Context           | Create a city report with all the cities in a country, organised from largest populated to smallest populated |
| Scope & Level         | Company, Primary function                                                                                     |
| Preconditions         | Database to be operative and connected.                                                                       |
| Success End Condition | Report of cities in a country from largest to smallest populated generated.                                   |
| Failed End Condition  | None report generated or an incorrect one.                                                                    |
| Primary Actors        | Organisation system user                                                                                      |
| Trigger               | Request the report from the database.                                                                         |


| DESCRIPTION   | STEP | ACTION                                                |
|---------------|---|-------------------------------------------------------|
|               | 1 | Request for population and cities information is made |
|               | 2 | Connect to database                                   |
|               | 3 | Report is produced                                    |
| EXTENSIONS    | Step | Branching Action                                      |
|               |   | No Extensions                                         |
| SUBVARIATIONS |   | Branching Action                                      |
|               | 1 | None                                                  |

| RELATED INFORMATION                    | 10. Create a city report with all the cities in a country   |
|----------------------------------------|---------------------------------|
| Priority                               | 1                               |
| Performance                            | Deer (1 minute)                 |
| Frequency                              | Once                            |
| Channels to actors                     | Population and cities database. |
| OPEN ISSUES                            | Database doesn't connect.       |
| Due Date                               | Release 1.0                     |

####11)

| USE CASE 11           | Create a city report with all the cities in a district organised from largest populated to smallest populated  |
|-----------------------|----------------------------------------------------------------------------------------------------------------|
| Goal in Context       | Create a city report with all the cities in a district, organised from largest populated to smallest populated |
| Scope & Level         | Company, Primary function                                                                                      |
| Preconditions         | Database to be operative and connected.                                                                        |
| Success End Condition | Report of cities in a district from largest to smallest populated generated.                                   |
| Failed End Condition  | None report generated or an incorrect one.                                                                     |
| Primary Actors        | Organisation system user                                                                                       |
| Trigger               | Request the report from the database.                                                                          |


| DESCRIPTION   | STEP | ACTION                                                |
|---------------|---|-------------------------------------------------------|
|               | 1 | Request for population and cities information is made |
|               | 2 | Connect to database                                   |
|               | 3 | Report is produced                                    |
| EXTENSIONS    | Step | Branching Action                                      |
|               |   | No Extensions                                         |
| SUBVARIATIONS |   | Branching Action                                      |
|               | 1 | None                                                  |

| RELATED INFORMATION                    | 11. Create a city report with all the cities in a district |
|----------------------------------------|------------------------------------------------------------|
| Priority                               | 1                                                          |
| Performance                            | Deer (1 minute)                                            |
| Frequency                              | Once                                                       |
| Channels to actors                     | Population and cities database.                            |
| OPEN ISSUES                            | Database doesn't connect.                                  |
| Due Date                               | Release 1.0                                                |

####12)


| USE CASE 12           | Create a report of top N populated cities in the world generated |
|-----------------------|-------------------------------------------------------------------------------------------------|
| Goal in Context       | Take an input from the user (N) and create a city report on the top N populated cities in the world |
| Scope & Level         | Company, Subfunction                                                                            |
| Preconditions         | Database to be operative and connected.                                                         |
| Success End Condition | Report of top N populated cities in the world generated.                                        |
| Failed End Condition  | None report generated or an incorrect one.                                                      |
| Primary Actors        | Organisation system user                                                                        |
| Trigger               | Request the report from the database.                                                           |


| DESCRIPTION   | STEP | ACTION                                                |
|---------------|---|-------------------------------------------------------|
|               | 1 | Request for population and cities information is made |
|               | 2 | Connect to database                                   |
|               | 3 | Report is produced                                    |
| EXTENSIONS    | Step | Branching Action                                      |
|               |   | No Extensions                                         |
| SUBVARIATIONS |   | Branching Action                                      |
|               | 1 | None                                                  |

| RELATED INFORMATION                    | 12. Create a report of top N populated cities in the world generated |
|----------------------------------------|----------------------------------------------------------------------|
| Priority                               | 1                                                                    |
| Performance                            | Deer (1 minute)                                                      |
| Frequency                              | Once                                                                 |
| Channels to actors                     | Population and cities database.                                      |
| OPEN ISSUES                            | Database doesn't connect.                                            |
| Due Date                               | Release 1.0                                                          |

####14)

| USE CASE 14           | Create a report of top N populated cities in a continent generated                                    |
|-----------------------|-------------------------------------------------------------------------------------------------------|
| Goal in Context       | Take an input from the user (N) and create a city report on the top N populated cities in a continent |
| Scope & Level         | Company, Subfunction                                                                                  |
| Preconditions         | Database to be operative and connected.                                                               |
| Success End Condition | Report of top N populated cities in a continent generated.                                            |
| Failed End Condition  | None report generated or an incorrect one.                                                            |
| Primary Actors        | Organisation system user                                                                              |
| Trigger               | Request the report from the database.                                                                 |


| DESCRIPTION   | STEP | ACTION                                                |
|---------------|---|-------------------------------------------------------|
|               | 1 | Request for population and cities information is made |
|               | 2 | Connect to database                                   |
|               | 3 | Report is produced                                    |
| EXTENSIONS    | Step | Branching Action                                      |
|               |   | No Extensions                                         |
| SUBVARIATIONS |   | Branching Action                                      |
|               | 1 | None                                                  |

| RELATED INFORMATION                    | 14. Create a report of top N populated cities in a continent generated |
|----------------------------------------|------------------------------------------------------------------------|
| Priority                               | 1                                                                      |
| Performance                            | Deer (1 minute)                                                        |
| Frequency                              | Once                                                                   |
| Channels to actors                     | Population and cities database.                                        |
| OPEN ISSUES                            | Database doesn't connect.                                              |
| Due Date                               | Release 1.0                                                            |

####15)

| USE CASE 15                                                                                                      | City report - populated cities                                                                                                                                                                               |
|------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Goal in Context                                                                                                  | As a software developer I want to take an input from the user (N) and create a city report on the top N populated cities in a region, to provide the organisation with easy access to population information. |
| Scope & Level                                                                                                    | Company, Seconadry Task                                                                                                                                                                                      |
| Preconditions                                                                                                    | A functioning SQL database.                                                                                                                                                                                  |
| Success End Condition                                                                                            | A new Table which shows the 'N' number most populated cities in a region.                                                                                                                                    |
| Failed End Condition                                                                                             | Inccorrect report generated, or no reported generated at all.                                                                                                                                                |
| Primary, Secondary Actors                                                                                        | Primary Actor, Company employee                                                                                                                                                                              |
| Trigger                                                                                                          | User requested city report                                                                                                                                                                                   |
| DESCRIPTION                                                                                                      | STEP                                                                                                                                                                                                         | ACTION           |
| ---------------                                                                                                  | ------                                                                                                                                                                                                       |------------------|
| Request for city report made                                                                                     | 1                                                                                                                                                                                                            |                  |
| Prompt user for region and number of cities 'N'                                                                  | 2                                                                                                                                                                                                            |                  |
| Create new table with the said region which displays 'N' number of cities which are most populated in the region | 3                                                                                                                                                                                                            |                  |
| EXTENSIONS                                                                                                       | Step                                                                                                                                                                                                         | Branching Action |
| No extensions                                                                                                    | 1a                                                                                                                                                                                                           |                  |
| SUBVARIATIONS                                                                                                    | None                                                                                                                                                                                                         | Branching Action |                                                                                                                                                                                                                   |                  |

| RELATED INFORMATION                    |                          |
|----------------------------------------|--------------------------|
| Priority                               | secondary                |
| Performance                            | Elephant                 |
| Frequency                              | Once                     |
| Channels to actors                     | Interactive database     |
| OPEN ISSUES                            | Database fails to connect |
| Due Date                               | Release 1.0              |
| ...Any other management information... |                          |
| Superordinates                         |                          |
| Subordinates                           |                          |

####16)

| USE CASE 16                                                                                                    | City report - populated cities                                                                                                                                                                                |
|----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Goal in Context                                                                                                | As a software developer I want to take an input from the user (N) and create a city report on the top N populated cities in a country, to provide the organisation with easy access to population information. |
| Scope & Level                                                                                                  | Company, Seconadry Task                                                                                                                                                                                       |
| Preconditions                                                                                                  | A functioning SQL database.                                                                                                                                                                                   |
| Success End Condition                                                                                          | A new Table which shows the 'N' number most populated cities in a country.                                                                                                                                    |
| Failed End Condition                                                                                           | Inccorrect report generated, or no reported generated at all.                                                                                                                                                 |
| Primary, Secondary Actors                                                                                      | Primary Actor, Company employee                                                                                                                                                                               |
| Trigger                                                                                                        | User requested city report                                                                                                                                                                                    |
| DESCRIPTION                                                                                                    | STEP                                                                                                                                                                                                          | ACTION           |
| ---------------                                                                                                | ------                                                                                                                                                                                                        |------------------|
| Request for city report made                                                                                   | 1                                                                                                                                                                                                             |                  |
| Prompt user for region and number of cities 'N'                                                                | 2                                                                                                                                                                                                             |                  |
| Create new table with the said region which displays 'N' number of cities which are most populated in the city | 3                                                                                                                                                                                                             |                  |
| EXTENSIONS                                                                                                     | Step                                                                                                                                                                                                          | Branching Action |
| No extensions                                                                                                  | 1a                                                                                                                                                                                                            |                  |
| SUBVARIATIONS                                                                                                  | None                                                                                                                                                                                                          | Branching Action |                                                                                                                                                                                                                   |                  |

| RELATED INFORMATION                    |                          |
|----------------------------------------|--------------------------|
| Priority                               | secondary                |
| Performance                            | Elephant                 |
| Frequency                              | Once                     |
| Channels to actors                     | Interactive database     |
| OPEN ISSUES                            | Database fails to connect |
| Due Date                               | Release 1.0              |
| ...Any other management information... |                          |
| Superordinates                         |                          |
| Subordinates                           |                          |

####17)

| USE CASE 17               |Pop organising|
|---------------------------|-----|
| Goal in Context           |As a software developer I want to take an input from the user (N) and create a city report on the top N populated cities in a district, to provide the organisation with easy access to population information.|
| Scope & Level             |Difficulty Medium Scope Deer|
| Preconditions             | n/a|
| Success End Condition     |Task Completed|
| Failed End Condition      |Find alternative option to complete task|
| Primary, Secondary Actors |Company employee|
| Trigger                   |Completion of Use Case #16|

| DESCRIPTION   | STEP | ACTION           |
|---------------|------|------------------|
|               | 1    |    Trigger       |
|               | 2    |    Create Report |
|               | 3    |    Fill Report   |
| EXTENSIONS    | Step | Branching Action |
|               | 1a   |                  |
| SUBVARIATIONS |      | Branching Action |
|               | 1    |                  |

| RELATED INFORMATION                    |   |
|----------------------------------------|---|
| Priority                               |  Critical importance |
| Performance                            | Deer  |
| Frequency                              | Once  |
| Channels to actors                     |  Population Database |
| OPEN ISSUES                            |  Access issues with Database |
| Due Date                               |  Release 1.0 |
| ...Any other management information... |   |
| Superordinates                         |   |
| Subordinates                           |   |

####18)

| USE CASE 18               | Cap City Pop organising                                             |
|---------------------------|---------------------------------------------------------------------|
| Goal in Context           | As a software developer I want to create a capital city report with all the capital cities in the world, organised from largest populated to smallest populated, to provide the organisation with easy access to population information. |
| Scope & Level             |                                                                                                                                                                                                                                     Difficulty Medium Scope Deer |
| Preconditions             |                                                                                                                                                                                                          n/a |
| Success End Condition     |Task Completed |
| Failed End Condition      |                                                                                                                                                                                                                                     Find alternative option to complete task|
| Primary, Secondary Actors |                                                                                                                                                                                                                                        Company employee|
| Trigger                   |   Completion of Use Case #17|

| DESCRIPTION   | STEP | ACTION           |
|---------------|------|------------------|
|               | 1    |    Trigger       |
|               | 2    |    Create Report |
|               | 3    |    Fill Report   |
| EXTENSIONS    | Step | Branching Action |
|               | 1a   |                  |
| SUBVARIATIONS |      | Branching Action |
|               | 1    |                  |

| RELATED INFORMATION                    |   |
|----------------------------------------|---|
| Priority                               |  Critical importance |
| Performance                            | Deer  |
| Frequency                              | Once  |
| Channels to actors                     |  Population Database |
| OPEN ISSUES                            |  Access issues with Database |
| Due Date                               |  Release 1.0 |
| ...Any other management information... |   |
| Superordinates                         |   |
| Subordinates                           |   |

####19)

| USE CASE 19     |Con Pop organising|
|-----------------|-----|
| Goal in Context |As a software developer I want to create a capital city report with all the capital cities in a continent, organised from largest populated to smallest populated, to provide the organisation with easy access to population information.|
| Scope & Level   |Difficulty Medium Scope Deer|
| Preconditions   |n/a|
| Success End Condition |Task Completed|
| Failed End Condition |Find alternative option to complete task|
| Primary, Secondary Actors |Company employee|
| Trigger         |Completion of Use Case #18|

| DESCRIPTION   | STEP | ACTION           |
|---------------|------|------------------|
|               | 1    |    Trigger       |
|               | 2    |    Create Report |
|               | 3    |    Fill Report   |
| EXTENSIONS    | Step | Branching Action |
|               | 1a   |                  |
| SUBVARIATIONS |      | Branching Action |
|               | 1    |                  |

| RELATED INFORMATION                    |   |
|----------------------------------------|---|
| Priority                               |  Critical importance |
| Performance                            | Deer  |
| Frequency                              | Once  |
| Channels to actors                     |  Population Database |
| OPEN ISSUES                            |  Access issues with Database |
| Due Date                               |  Release 1.0 |
| ...Any other management information... |   |
| Superordinates                         |   |
| Subordinates                           |   |

####20)

| USE CASE 20               | City organising|
|---------------------------|-----|
| Goal in Context           | As a software developer I want to create a capital city report with all the capital cities in a region, organised from largest populated to smallest populated, to provide the organisation with easy access to population information.|
| Scope & Level             | Difficulty Medium Scope Deer|
| Preconditions             |n/a|
| Success End Condition     | Task Completed|
| Failed End Condition      | Find alternative option to complete task|
| Primary, Secondary Actors | Company employee|
| Trigger                   |Completion of Use Case #19|

| DESCRIPTION   | STEP | ACTION           |
|---------------|------|------------------|
|               | 1    |    Trigger       |
|               | 2    |    Create Report |
|               | 3    |    Fill Report   |
| EXTENSIONS    | Step | Branching Action |
|               | 1a   |                  |
| SUBVARIATIONS |      | Branching Action |
|               | 1    |                  |

| RELATED INFORMATION                    |   |
|----------------------------------------|---|
| Priority                               |  Critical importance |
| Performance                            | Deer  |
| Frequency                              | Once  |
| Channels to actors                     |  Population Database |
| OPEN ISSUES                            |  Access issues with Database |
| Due Date                               |  Release 1.0 |
| ...Any other management information... |   |
| Superordinates                         |   |
| Subordinates                           |   |

####21)

| USE CASE 21                | Cap organising|
|---------------------------|-----|
| Goal in Context           |As a software developer I want to take an input from the user (N) and create a capital city report on the top N populated cities in the world, to provide the organisation with easy access to population information.|
| Scope & Level             | Difficulty Medium Scope Deer|
| Preconditions             | n/a|
| Success End Condition     |Task Completed|
| Failed End Condition      |Find alternative option to complete task|
| Primary, Secondary Actors | Company employee|
| Trigger                   | Completion of Use Case #20|

| DESCRIPTION   | STEP | ACTION           |
|---------------|------|------------------|
|               | 1    |    Trigger       |
|               | 2    |    Create Report |
|               | 3    |    Fill Report   |
| EXTENSIONS    | Step | Branching Action |
|               | 1a   |                  |
| SUBVARIATIONS |      | Branching Action |
|               | 1    |                  |

| RELATED INFORMATION                    |   |
|----------------------------------------|---|
| Priority                               |  Critical importance |
| Performance                            | Deer  |
| Frequency                              | Once  |
| Channels to actors                     |  Population Database |
| OPEN ISSUES                            |  Access issues with Database |
| Due Date                               |  Release 1.0 |
| ...Any other management information... |   |
| Superordinates                         |   |
| Subordinates                           |   |

####22)

| USE CASE 22               |Organising|
|---------------------------|-----|
| Goal in Context           |As a software developer I want to take an input from the user (N) and create a capital city report on the top N populated cities in a continent, to provide the organisation with easy access to population information.|
| Scope & Level             |Difficulty Medium Scope Deer|
| Preconditions             | n/a|
| Success End Condition     | Task Completed|
| Failed End Condition      | Find alternative option to complete task|
| Primary, Secondary Actors | Company employee|
| Trigger                   |Completion of Use Case #21|

| DESCRIPTION   | STEP | ACTION           |
|---------------|------|------------------|
|               | 1    |    Trigger       |
|               | 2    |    Create Report |
|               | 3    |    Fill Report   |
| EXTENSIONS    | Step | Branching Action |
|               | 1a   |                  |
| SUBVARIATIONS |      | Branching Action |
|               | 1    |                  |

| RELATED INFORMATION                    |   |
|----------------------------------------|---|
| Priority                               |  Critical importance |
| Performance                            | Deer  |
| Frequency                              | Once  |
| Channels to actors                     |  Population Database |
| OPEN ISSUES                            |  Access issues with Database |
| Due Date                               |  Release 1.0 |
| ...Any other management information... |   |
| Superordinates                         |   |
| Subordinates                           |   |

####23)

| USE CASE 23                                                                                                      | City report - populated cities                                                                                                                                                                                |
|------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Goal in Context                                                                                                  | As a software developer I want to take an input from the user (N) and create a city report on the top N populated cities in a region, to provide the organisation with easy access to population information. |
| Scope & Level                                                                                                    | Company, Seconadry Task                                                                                                                                                                                       |
| Preconditions                                                                                                    | A functioning SQL database.                                                                                                                                                                                   |
| Success End Condition                                                                                            | A new Table which shows the 'N' number most populated cities in a region.                                                                                                                                     |
| Failed End Condition                                                                                             | Inccorrect report generated, or no reported generated at all.                                                                                                                                                 |
| Primary, Secondary Actors                                                                                        | Primary Actor, Company employee                                                                                                                                                                               |
| Trigger                                                                                                          | User requested city report                                                                                                                                                                                    |
| DESCRIPTION                                                                                                      | STEP                                                                                                                                                                                                          | ACTION           |
| ---------------                                                                                                  | ------                                                                                                                                                                                                        |------------------|
| Request for city report made                                                                                     | 1                                                                                                                                                                                                             |                  |
| Prompt user for region and number of cities 'N'                                                                  | 2                                                                                                                                                                                                             |                  |
| Create new table with the said region which displays 'N' number of cities which are most populated in the region | 3                                                                                                                                                                                                             |                  |
| EXTENSIONS                                                                                                       | Step                                                                                                                                                                                                          | Branching Action |
| No extensions                                                                                                    | 1a                                                                                                                                                                                                            |                  |
| SUBVARIATIONS                                                                                                    | None                                                                                                                                                                                                          | Branching Action |                                                                                                                                                                                                                   |                  |

| RELATED INFORMATION                    |                          |
|----------------------------------------|--------------------------|
| Priority                               | secondary                |
| Performance                            | Elephant                 |
| Frequency                              | Once                     |
| Channels to actors                     | Interactive database     |
| OPEN ISSUES                            | Database fails to connect |
| Due Date                               | Release 1.0              |
| ...Any other management information... |                          |
| Superordinates                         |                          |
| Subordinates                           |                          |

####24)

| USE CASE 24                                                                                                | Languages report                                                                                                                                                                                                                      |
|------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Goal in Context                                                                                            | As a software developer I want to create a languages report on the number of people and the percentage of the world population who speak different languages, to provide the organisation with easy access to population information. |
| Scope & Level                                                                                              | Company, Seconadry Task                                                                                                                                                                                                               |
| Preconditions                                                                                              | A functioning SQL database.                                                                                                                                                                                                           |
| Success End Condition                                                                                      | A new Table which shows the number of people and % of world population who speak different languages.                                                                                                                                 |
| Failed End Condition                                                                                       | Inccorrect report generated, or no reported generated at all.                                                                                                                                                                         |
| Primary, Secondary Actors                                                                                  | Primary Actor, Company employee                                                                                                                                                                                                       |
| Trigger                                                                                                    | User requested language report                                                                                                                                                                                                        |
| DESCRIPTION                                                                                                | STEP                                                                                                                                                                                                                                  | ACTION           |
| ---------------                                                                                            | ------                                                                                                                                                                                                                                |------------------|
| Request for language report made                                                                           | 1                                                                                                                                                                                                                                     |                  |
| connect to database                                                                                        | 2                                                                                                                                                                                                                                     |                  |
| Create new table which shows the number of people and % of world population who speak different languages. | 3                                                                                                                                                                                                                                     |                  |
| EXTENSIONS                                                                                                 | Step                                                                                                                                                                                                                                  | Branching Action |
| No extensions                                                                                              | 1a                                                                                                                                                                                                                                    |                  |
| SUBVARIATIONS                                                                                              | None                                                                                                                                                                                                                                  | Branching Action |                                                                                                                                                                                                                   |                  |

| RELATED INFORMATION                    |                           |
|----------------------------------------|---------------------------|
| Priority                               | secondary                 |
| Performance                            | Hippo                     |
| Frequency                              | Once                      |
| Channels to actors                     | Interactive database      |
| OPEN ISSUES                            | Database fails to connect |
| Due Date                               | Release 1.0               |
| ...Any other management information... |                           |
| Superordinates                         |                           |
| Subordinates                           |                           |
