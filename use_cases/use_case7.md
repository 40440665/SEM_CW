| USE CASE #                          | City report                                                                                                                                                                                                       |
|-------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Goal in Context                     | As a software developer I want to create a city report with all the cities in the world, organised from largest populated to smallest populated, to provide the organisation with easy access to population information. |
| Scope & Level                       | Company, Primary Task                                                                                                                                                                                             |
| Preconditions                       | A functioning SQL database.                                                                                                                                                                                       |
| Success End Condition               | A new Table which shows all the cities sorted by population ASC.                                                                                                                                                  |
| Failed End Condition                | Inccorrect report generated, or no reported generated at all.                                                                                                                                                     |
| Primary, Secondary Actors           | Primary Actor, Company employee                                                                                                                                                                                   |
| Trigger                             | User requested city report                                                                                                                                                                                        |
| DESCRIPTION                         | STEP                                                                                                                                                                                                              | ACTION           |
| ---------------                     | ------                                                                                                                                                                                                            |------------------|
| Request for city report made        | 1                                                                                                                                                                                                                 |                  |
| Connect to database                 | 2                                                                                                                                                                                                                 |                  |
| Create new table and display to user | 3                                                                                                                                                                                                                 |                  |
| EXTENSIONS                          | Step                                                                                                                                                                                                              | Branching Action |
| No extensions                       | 1a                                                                                                                                                                                                                |                  |
| SUBVARIATIONS                       | None                                                                                                                                                                                                              | Branching Action |                                                                                                                                                                                                                   |                  |

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
