# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

iStudy is a Bible study application with two independently runnable modules:
- `is-server/` — Spring Boot 3.4 / Java 21 reactive backend (WebFlux + R2DBC + PostgreSQL)
- `is-client/` — Angular 18 frontend (Angular Material + Bootstrap 5)

## Commands

### Server (`is-server/`)

```bash
# Run (requires local PostgreSQL — see database setup below)
./mvnw spring-boot:run -Dspring-boot.run.profiles=local

# Build (includes checkstyle + tests)
./mvnw clean install

# Tests only
./mvnw test

# Run a single test class
./mvnw test -Dtest=StudyServiceTest

# Checkstyle only
./mvnw checkstyle:check
```

### Client (`is-client/`)

```bash
npm install          # first-time setup
npm start            # dev server at http://localhost:4200
npm test             # Karma/Jasmine tests (headless Chrome)
npm run build        # production build to dist/is-client/
```

### Database (Docker)

```bash
docker run --name postgres -e POSTGRES_PASSWORD=scurtis -d -p 5432:5432 postgres
```

The `local` Spring profile (`application-local.yml`) connects to `localhost:5432/istudyDB` with user `postgres` / password `scurtis`. Flyway runs migrations automatically on startup.

## Architecture

### Server

The server is fully reactive — it uses Spring WebFlux and R2DBC (no blocking I/O). The layering is:

```
Controller → Service → Repository (R2DBC) → PostgreSQL
                  ↕
              Converter (entity ↔ DTO)
```

- **Controller** (`StudyController`) — single REST controller; no business logic, delegates entirely to `StudyService`. Returns `Mono<T>` / `Flux<T>`.
- **Service** (`StudyService`) — orchestrates repositories; maps entities to DTOs via injected converters.
- **Converters** — plain `@Component` classes with `toDto()` / `toEntity()` methods (no MapStruct). Each domain object has its own converter.
- **Repositories** — Spring Data R2DBC interfaces extending `R2dbcRepository`.
- **Config** — `PostgresR2dbc` validates that R2DBC connection properties are set at startup. `CorsGlobalConfig` allows all origins/methods (dev-mode CORS).

Database schema lives in `src/main/resources/db/migration/` as Flyway versioned SQL scripts (`V1__`, `V2__`, …) targeting the `istudy` schema.

Tests use H2 in-memory with `r2dbc-h2`; Flyway is disabled in the test profile — migrations are not run against H2.

### Client

Module-based Angular (not standalone components). All components are declared in `AppModule`. Routing defined directly in `AppModule`:

| Path | Component |
|---|---|
| `/dashboard` | `DashboardComponent` |
| `/study` | `StudyComponent` |
| `/study-types` | `StudyTypesComponent` |
| `**` | redirects to `/dashboard` |

- **`HttpService`** — single service for all API calls; hardcodes `http://localhost:8080` as the backend base URL. All methods return `Observable<T>`.
- **`MaterialModule`** (`src/app/common/material.module.ts`) — central re-export of all Angular Material modules used by the app.
- **Global styles** — `src/assets/styles/variables.scss` for SCSS variables, `common.scss` for shared rules, `modal-dialogs.scss` for dialog overrides.

### Code Style (Server)

Checkstyle enforces Google Java Style with project-specific overrides:
- Max line length: 200 characters
- 4-space indentation (no tabs)
- No star imports; imports ordered: third-party then static
- Coverage check (JaCoCo): ≥80% line coverage on service/converter/model classes; config, controller, dto, entity, and repository packages are excluded from coverage requirements.
