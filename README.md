A rota padrão da nossa api é /api.

Nossa API foi divida em módulos, sendo eles:
- student
- questions
- loginlog
- guardian
- curriculum
- classes
- alternavites
- activities
- actions

Onde em grande parte deles temos um GET e POST para a rota "/"

Em student temos uma rota diferente, onde nós buscamos um aluno pelo e-mail do responsável
- {server}/api/student/{email}

Em activity temos uma para pegar uma atividade pelo código da aula
- {server}/api/activities/{id}

Em questions temos uma para pegar uma questão pelo código da atividade
- {server}/api/questions/{id}

Em activities temos uma para pegar uma atividade pelo código da aula
- {server}/api/activities/{id}

Em alternatives temos uma para pegar uma alternativa pelo código da questão
- {server}/api/alternatives/{id}

Em actions temos como pegar a quantidade de dias consecutivos que um aluno fez uma tarefa pelo seu id
- {server}/api/actions/consecutiveDays/{id}


No mobile, utilizamos as seguintes rotas:
@GET("/api/student/{email}")
Call<ApiResponse<Student>> getStudent(@Path("email") String email);

    @POST("api/loginlog")

    @POST("api/student")

    POST("api/guardian")