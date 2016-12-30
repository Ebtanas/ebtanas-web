# Milestone to Alpha
This will be what to be the sotware is in the future. See changelog for progress.
In Alpha all standard website is working (crud) and validated.

## 0.0.1 - Frontend View
Make the frontend works look like in the mockup.

### 0.0.11
- Make all routes works, either with or not paramater request.
- For `/page/:page-name` where `:page-name` is page name

### 0.0.12
- Refactor frontend dbs, no more static writing. All frontend data is pulled from db namespace.

### 0.0.121
- Make a database model and anlyze what form is needed.

### 0.0.13
- Make static html dashboard for admin, a wellcome admin dashboard.

### 0.0.131
- Form add problem with its attributes based on database model.

### 0.0.14
- Make a handler, routing, and view for static html.

## 0.0.2 - Signup as Member
Make a session with registered user, destroy session, remember me time default when login. Change nav when session changes.

### 0.0.2
- Make a connection to `db` with postgres.

### 0.0.21
- Represent data-modeling with table.
- `Manager` roles active by default by time exec the query.sql.
- Make a table for storing `user` sign-up data.

### 0.0.22
- Signup form is working.
- Data is validated.

### 0.0.23
- User can login with its account.
- User can logout with its account.

## 0.0.3 - CRUD the Problem-set
Admin can write the problem to the website. Math equation using latex, can upload image too.

### 0.0.3
- Make `POST` handler subject study.
- Make `GET` handler subject study.
- Make `PATCH` handler subject study.
- Make `DELETE` handler subject study.

## 0.0.4 - Search Results and Pagging
Make search form works and display by 10 results. Link search result to the problem-set.