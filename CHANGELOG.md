# Change Log
All notable changes to this project will be documented in this file.

## 0.0.1 - 07-12-2016
### Bug
- [0.0.11-a] Sometime `/masuk` and `/daftar-anggota` render same page, the state being used doesn't behive like use to be.
- [0.0.111] SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
- [0.0.111] SLF4J: Defaulting to no-operation (NOP) logger implementation.
- [0.0.111] SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.


### Fix
- [0.0.11] Make different modules on `:cljsbuild` in `:min` profile with additional parameter on fn `ebtanas.views.common/footer-js-min`.
- [0.0.111] ~ 08-12-2016 ~ Fix SLF47 error with `[ch.qos.logback/logback-classic "1.1.7"]`.

### Remove
- [0.0.111] Static css on resources.

### Add
- [0.0.111] Instead static, now using `[ring-webjars "0.1.1"]` and `[org.webjars.npm/spectre.css "0.1.29"]` for css.
- [0.0.111] Update middleware and add wrap-webjars.

### Update
- [0.0.111] `ebtanas.views.common` updated static asset to dynamic asset from `[org.webjars.npm/spectre.css "0.1.29"]`.

## 0.0.11-a - 11-12-2016
### Update
- [0.0.11-a] Refactor namespace `ebtanas.views.db` to `ebtanas.db.static-db`.
- [0.0.11-a] Use ns `ebtanas.db.static-queries` to access static db, so no direct access to db anymore.

## 0.0.1 - 11-12-2016
### Update
- [0.0.11]
- Make all routes works, either with or not paramater request.
- For `/page/:page-name` where `:page-name` is page name.

- [0.0.11-a]
- Update page title.

## 0.0.2 - 25-12-2016
### Add
- Making a postgres connection, abstraction with hugsql.

## 0.0.2-1 - 25-12-2016
### Update
- Different conection per environment.

## 0.0.2-2 - 28-12-2016
### Update
- Database logic and abstraction for signup is working.

### Add
- Add Swagger-ui for manual testing.
- Registration validation on front-end.

## 0.0.2-2c - 28-12-2016
### Update
- onKeyDown event more robust and precision with tab clik.