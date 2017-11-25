set /a begin = ((%1-1)/50 * 50) + 1
set /a end = ((%1-1)/50 * 50) + 50

echo %begin%-%end%

if not exist %begin%-%end% (
    mkdir %begin%-%end%
)

cd %begin%-%end%

if not exist Q%1 (
    mkdir Q%1
    cd.> Q%1/Q%1.java
    cd.> Q%1/Q%1.md
) else (
    echo already exist
)

echo success