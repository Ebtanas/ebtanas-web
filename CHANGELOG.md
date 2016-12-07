# Change Log
All notable changes to this project will be documented in this file.

## 0.0.1 - 07-12-2016
### Bug
- [0.0.11] Sometime `/masuk` and `/daftar-anggota` render same page, the state being used doesn't behive like use to be.
- [0.0.111] SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
- [0.0.111] SLF4J: Defaulting to no-operation (NOP) logger implementation
- [0.0.111] SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.


### Fix
- [0.0.11] Make different modules on `:cljsbuild` in `:min` profile with additional parameter on fn `ebtanas.views.common/footer-js-min`

### Remove
- [0.0.111] Static css on resources

### Add
- [0.0.111] Instead static, now using `[ring-webjars "0.1.1"]` and `[org.webjars.npm/spectre.css "0.1.29"]` for css
- [0.0.111] Update middleware and add wrap-webjars

### Update
- [0.0.111] `ebtanas.views.common` updated static asset to dynamic asset from `[org.webjars.npm/spectre.css "0.1.29"]`