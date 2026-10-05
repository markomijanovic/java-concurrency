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

## Context

Educational project by Marko Mijanovic, University of Belgrade, School of Electrical Engineering. Course scaffolding and supplied assets remain part of the project; this preparation does not grant a new license to third-party material.

## Preparation validation

- javac all sources: passed.
