| USE CASE #                | 4 Produce a population report of all countries in the world defined by a user input   |
|---------------------------|-----|
| Goal in Context           |   As a software developer I want to take an input from the user (N) and create a country report on the top N populated countries in the world, to provide the organisation with easy access to population information. |
| Scope & Level             | Company, Primary Task   |
| Preconditions             | Connection to the database   |
| Success End Condition     | Complete report created on all countries in a region organised from largest populated to smallest populated.   |
| Failed End Condition      | No report is produced.   |
| Primary Actor | Company employee.   |
| Trigger                   | A request for population information is made.   |

| DESCRIPTION   | STEP | ACTION           |
|---------------|------|------------------|
|               | 1    |      Request for population information is made            |
|               | 2    |      Get user input            |
|               | 3    |      Connect to database            |
|               | 4    |      Report is produced            |
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
