# Change Log
All notable changes to this project will be documented in this file.

## 0.0.1 - 07-12-2016
### Bug
- [0.0.11] Sometime `/masuk` and `/daftar-anggota` render same page, the state being used doesn't behive like use to be.

### Fix
- [0.0.11] Make different modules on `:cljsbuild` in `:min` profile with additional parameter on fn `ebtanas.views.common/footer-js-min`