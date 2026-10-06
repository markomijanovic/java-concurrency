# Java Concurrency Exercises

A collection of educational Java concurrency exercises: bounded buffers, producers, semaphores, dining philosophers, and a clock worker. It includes alternative and work-in-progress implementations rather than one production application.

## Compile

Requires JDK 11 or later. From PowerShell:

```powershell
New-Item -ItemType Directory -Force build | Out-Null
$sources = Get-ChildItem src -Recurse -Filter *.java | ForEach-Object FullName
javac -encoding UTF-8 -d build $sources
java -cp build ra.ac.bg.etf.kdp.cas.Dining_Philosophers
```

Some demonstrations run indefinitely; stop them with Ctrl+C. Compiling the examples does not establish freedom from deadlock, starvation, or race conditions. Review individual implementations before using them as synchronization references.

## Exercise map

| Entry point / source | Purpose |
|---|---|
| `Dining_Philosophers` / `Philosopher` | Five philosophers sharing semaphore-controlled forks |
| `mainTest` / `BoundedBuffer` | Producer and consumer exchanging ten integers |
| `SemaphoreKDP` | Standalone semaphore exercise |
| `boundedbuffgotova`, `boundeduff` | Alternative buffer implementations |
| `clock`, `Producer`, `Test` | Supporting exercises |

To run the finite buffer demonstration, use `java -cp build ra.ac.bg.etf.kdp.cas.mainTest`. The package name is retained from the coursework.

## Context

Educational project by [Marko Mijanovic](https://github.com/markomijanovic), University of Belgrade, School of Electrical Engineering. Supplied course scaffolding and assets retain their original licensing terms.

## Verification

- All sources compile with JDK 11; unchecked generic-array warnings remain.
- The finite producer-consumer demo completed successfully.
- This does not prove all exercises are free of deadlocks, races, or starvation.
