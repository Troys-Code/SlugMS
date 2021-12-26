REM // 'launchtest.bat' Author: Tochi
@echo off
set a=0
title SlugMS: Offline
color 1b
:clear
cls
echo SlugMS Server Launcher
echo.
echo Commands:
echo -------------------------------------------------------------
echo start - Start SlugMS server
echo shutdown - Shut down SlugMS server and close Launcher File
echo reset - Resets SlugMS Launcher File
echo clear - Clear this window
echo -------------------------------------------------------------
echo.

:command
set /p s="Enter command: "
if "%s%"=="start" goto :start
if "%s%"=="shutdown" goto :shutdown
if "%s%"=="reset" goto :reset
if "%s%"=="clear" goto :clear
echo Wrong Command.
echo.
goto :command

:start
if "%a%"=="1" (
echo SlugMS is already active!
echo.
goto :command
)
color 4c
echo This might take a while....
echo.
title SlugMS: activating
echo Server Launching...
start /b launch.bat
color 2a
title SlugMS: Online
set a=1
ping localhost -w 10000 >nul
echo.
goto :command

:shutdown
color 4c
title SlugMS: Shutting Down...
echo The Server Launcher will be close in a few seconds.
ping localhost -w 100000 >nul
taskkill /im cmd.exe

:reset
color 4c
title SlugMS: Resetting...
echo Please type 'start' in command box after bat file have been resetted.
ping localhost -w 100000 >nul
start launchtest.bat	REM // thanks Paxum for noting that 'launchtest.bat' is to be used here
taskkill /im cmd.exe