import java.util.*;

enum Err{
    NoError,                                // нет ошибок
    OutOfRange,                             // выход за границы анализируемой строки
    SignedExceptions,                        // ожидается знак
    SignedDigitExceptions,                  // ожидается знак или цифра
    SignedNewLineExceptions,                // ожидается знак или перенос строки
    DigitExceptions,                        // ожидается цифра
    DigitBracketExceptions,                 // ожидается цифра или ']'
    LetterExceptions,                       // ожидается буква
    LetterUnderExceptions,                  // ожидается буква или нижнее подчёркивание
    LetterUnderDigitalExceptions,           // ожидается буква, нижнее подчёркивание или цифра
    LetterUnderSpaceRParenExceptions,       // ожидается буква, нижние подчёркивание, отступ или ')'
    LetterUnderSpaceRBracketExceptions,     // ожидается буква, нижние подчёркивание, отступ или '] '
    LetterDigitLParenIndentExceptions,      // ожидается буква, цифра, нижнее подчёркивание или '('
    LetterDigitUnderLBracketAssign,         // ожидается буква, цифра, нижнее подчёркивание, '[' или '='
    LetterDigitUnderLBracketExceptions,     // ожидается буква, цифра, нижнее подчёркивание или '['
    LetterDigitUnderLBracketNewLine,        // ожидается буква, цифра, нижнее подчёркивание, '[' или перенос строки
    LetterUnderRParenColonCommaExceptions,  // ожидается буква, нижние подчёркивание, ')', ':' или ','
    LetterDigitSignedException,              // ожидается буква, цифра или '-'
    LetterDigitUnderRBracketExceptions,     // ожидается буква, цифра, нижнее подчёркивание или ']'
    LBracketAssignExceptions,               // ожидается '[' или '='
    LBracketAssignNewLineSignedExceptions,  // ожидается '[', '=', перенос строки или знак
    ColonRParenExceptions,                  // ожидается ':' или ')'
    IndentDigitExceptions,                  // ожидается отступ или буква
    TypeExceptions,                         // ожидается буква из зарезервированных слов: (int, float, set)
    TypeIndentExceptions,                   // ожидается буква из зарезервированных слов: (int, float, set) или отступ
    ControlExceptions,                      // ожидается буква из зарезервированного слова: return
    ControlIndentExceptions,                // ожидается буква из зарезервированного слова: return или отступ
    RParenCommaExceptions,                  // ожидается ')'  или ','
    IndentColonExceptions,                  // ожидается отступ или ':'
    LParenExceptions,                       // ожидается '('
    RParenExceptions,                       // ожидается ')'
    ColonExceptions,                        // ожидается ':'
    CommaExceptions,                        // ожидается ','
    LBracketExceptions,                     // ожидается '['
    RBracketExpected,                       // ожидается ']'
    NewLineExceptions,                      // ожидается перенос строки
    IndentExceptions,                       // ожидается отступ
    AssignExceptions,                       // ожидается '='
    AssignIndentExceptions,                 // ожидается '=' или отступ
    IntLongExceptions,                      // число  содержит больше 10 цифр
    InvalidNumber,                          // ? некорректное число
    UnexpectedChar,                         // неожиданный символ
    UnrecognizedError                        // неизвестная ошибка
}

class Result{
    private int _errPosition;
    private Err _Err;
    public Result(int ErrPosition, Err err){
        _errPosition = ErrPosition;
        _Err = err;
    }

    public int ErrPosition(){ return _errPosition;}

    public String ErrMessage(){
        switch( _Err) {
            case Err.NoError: return  "нет ошибок ";
            case Err.OutOfRange: return  "выход за границы анализируемой строки ";
            case Err.SignedExceptions: return  "ожидается знак ";
            case Err.SignedDigitExceptions: return  "ожидается знак или цифра ";
            case Err.DigitExceptions: return  "ожидается цифра ";
            case Err.DigitBracketExceptions: return  "ожидается цифра или ']' ";
            case Err.LetterExceptions: return  "ожидается буква ";
            case Err.LetterUnderExceptions: return  "ожидается буква или нижнее подчёркивание ";
            case Err.LetterUnderDigitalExceptions: return  "ожидается буква, нижнее подчёркивание или цифра ";
            case Err.LetterUnderSpaceRParenExceptions: return  "ожидается буква, нижние подчёркивание, отступ или ')' ";
            case Err.LetterUnderSpaceRBracketExceptions: return  "ожидается буква, нижние подчёркивание, отступ или '] ' ";
            case Err.IndentDigitExceptions: return  "ожидается отступ или буква ";
            case Err.TypeExceptions: return  "ожидается буква из зарезервированных слов: (int, float, set) ";
            case Err.TypeIndentExceptions: return  "ожидается буква из зарезервированных слов: (int, float, set) или отступ ";
            case Err.ControlExceptions: return  "ожидается буква из зарезервированного слова: return ";
            case Err.ControlIndentExceptions: return  "ожидается буква из зарезервированного слова: return или отступ ";
            case Err.RParenCommaExceptions: return  "')' или ',' ";
            case Err.IndentColonExceptions: return  "ожидается отступ или ':' ";
            case Err.LParenExceptions: return  "ожидается '(' ";
            case Err.RParenExceptions: return  "ожидается ')' ";
            case Err.ColonExceptions: return  "ожидается ':' ";
            case Err.CommaExceptions: return  "ожидается ',' ";
            case Err.LBracketExceptions: return  "ожидается '[' ";
            case Err.RBracketExpected: return  "ожидается ']' ";
            case Err.NewLineExceptions: return  "ожидается перенос строки ";
            case Err.IndentExceptions: return  "ожидается отступ ";
            case Err.AssignExceptions: return  "ожидается '=' ";
            case Err.AssignIndentExceptions: return  "ожидается '=' или отступ ";
            case Err.IntLongExceptions: return  "число содержит больше 10 цифр ";
            case Err.InvalidNumber: return  "? некорректное число ";
            case Err.UnexpectedChar: return  "неожиданный символ ";
            case Err.UnrecognizedError: return  "неизвестная ошибка ";
            case Err.LetterDigitLParenIndentExceptions: return  "ожидается буква, цифра, нижнее подчёркивание или '(' ";
            case Err.LetterUnderRParenColonCommaExceptions: return  "ожидается буква, нижние подчёркивание, ')', ':' или ',' ";
            case Err.ColonRParenExceptions: return  "ожидается ':' или ')' ";
            case Err.LetterDigitUnderLBracketAssign: return  "ожидается буква, цифра, нижнее подчёркивание, '[' или '=' ";
            case Err.LBracketAssignExceptions: return  "ожидается '[' или '=' ";
            case Err.LetterDigitUnderLBracketNewLine: return  "ожидается буква, цифра, нижнее подчёркивание, '[' или перенос строки ";
            case Err.LBracketAssignNewLineSignedExceptions: return  "ожидается '[', '=', перенос строки или знак ";
            case Err.LetterDigitSignedException: return  "ожидается буква, цифра или '-' ";
            case Err.LetterDigitUnderRBracketExceptions: return  "ожидается буква, цифра, нижнее подчёркивание или ']' ";
            case Err.LetterDigitUnderLBracketExceptions: return  "ожидается буква, цифра, нижнее подчёркивание или '[' ";
            case Err.SignedNewLineExceptions: return  "ожидается знак или перенос строки ";
            default: return  "неизвестная ошибка ";
        }
    }

    static class CheckFunctionDef{
        private enum EnumState {
            Start, Error, Final, S2, S3, S4, S5, S6, S7, S8,
            S9, S10, S11, S12, S13, S14, S15, S16, S17, S18, S19,
            S20, S21, S22, S23, S24, S25, S26, S27, S28, S29, S30,
            S31, S32, S33, S35, S36, S37, S38, S39, S40, S41,
            S42, S43, S44, S45, S46, S47, S48, S50, S51, S52, S53,
            S54, S55, S56, S57, S58, S59, S60, S61, S62, S63, S64, S65,
            S66, S67, S68, S69, S70, S71, S72, S73, S74, S75, S76,
            S77, S78, S79, S80, S81, S82, S83, S85, S6b, S9b, S26b,
            S31b, S27b, S62b, S28b, S64b, S32b, S61b, S33b, S63b,
            S66b, S85b, S67b, S68b
        }

        private static int _Pos;
        private static String _Str;
        private static Err _Err;
        private static int _ErrPos;

        private static void SetError (Err ErrorType, int ErrorPosition){
            _Err = ErrorType;
            _ErrPos = ErrorPosition;
        }

        public static Result Check(String inputString){
            _Pos = 0;
            _Str = inputString;
            SetError(Err.NoError, -1);
            Def();
            return new Result(_ErrPos, _Err);
        }

        private static boolean Def(){
            EnumState state = EnumState.Start;

            while ((state != EnumState.Error) && (state != EnumState.Final)){
                if (_Pos >= _Str.length()){
                    // ИСПРАВЛЕНИЕ 0: Корректная обработка конца строки
                    if (state == EnumState.S59) state = EnumState.Final;
                    else { SetError(Err.OutOfRange, _Pos - 1); state = EnumState.Error; }
                }
                else{
                    switch (state){
                        case EnumState.Start:
                            if (_Str.charAt(_Pos) == 'd') state = EnumState.S2;
                            else { SetError(Err.LetterExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S2:
                            if (_Str.charAt(_Pos) == 'e') state = EnumState.S3;
                            else { SetError(Err.LetterExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S3:
                            if (_Str.charAt(_Pos) == 'f') state = EnumState.S4;
                            else { SetError(Err.LetterExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S4:
                            if (_Str.charAt(_Pos) == ' ') state =  EnumState.S5;
                            else { SetError(Err.IndentExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S5:
                            if (Character.isLetter(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) state = EnumState.S6;
                            else if(_Str.charAt(_Pos) == ' ') state = EnumState.S5;
                            else { SetError(Err.LetterUnderExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S6:
                            if (Character.isLetterOrDigit (_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) state = EnumState.S6;
                            else if (_Str.charAt(_Pos) == '(') state = EnumState.S7;
                            else if (_Str.charAt(_Pos) == ' ') state =  EnumState.S6b;
                            else { SetError(Err.LetterDigitLParenIndentExceptions,_Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S6b:
                            if (_Str.charAt(_Pos) == '(') state = EnumState.S7;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S6b;
                            else { SetError(Err.LParenExceptions,_Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S7:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S7;
                            else if (Character.isLetter(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) state = EnumState.S9;
                            else if (_Str.charAt(_Pos) == ')') state = EnumState.S8;
                            else { SetError(Err.LetterUnderSpaceRParenExceptions,_Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S9:
                            if (Character.isLetterOrDigit(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) state = EnumState.S9;
                            else if (_Str.charAt(_Pos) == ')') state =  EnumState.S8;
                            else if (_Str.charAt(_Pos) == ':') state = EnumState.S10;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S9b;
                            else if (_Str.charAt( _Pos) == ',') state = EnumState.S22;
                            else { SetError(Err.LetterUnderRParenColonCommaExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S9b:
                            if (_Str.charAt(_Pos) == ':') state = EnumState.S10;
                            else if (_Str.charAt(_Pos) == ')') state = EnumState.S8;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S9b;
                            else { SetError(Err.ColonRParenExceptions,_Pos); state =  EnumState.Error; }
                            break;

                        case EnumState.S10:
                            if(_Str.charAt(_Pos) == 's') state = EnumState.S19;
                            else if(_Str.charAt(_Pos) == 'i') state = EnumState.S11;
                            else if(_Str.charAt(_Pos) == 'f') state = EnumState.S14;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S10;
                            else { SetError(Err.TypeExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S19:
                            if (_Str.charAt(_Pos) == 'e') state = EnumState.S20;
                            else { SetError(Err.TypeExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S20:
                            if (_Str.charAt(_Pos) == 't') state = EnumState.S21;
                            else { SetError(Err.TypeExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S21:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S21;
                            else if (_Str.charAt(_Pos) == ')') state = EnumState.S8;
                            else if (_Str.charAt(_Pos) == ',' ) state = EnumState.S22;
                            else { SetError(Err.RParenCommaExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S11:
                            if ( _Str.charAt(_Pos) == 'n') state = EnumState.S12;
                            else { SetError(Err.TypeExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S12:
                            if (_Str.charAt(_Pos) == 't') state = EnumState.S13;
                            else { SetError(Err.TypeExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S13:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S13;
                            else if (_Str.charAt(_Pos) == ')') state = EnumState.S8;
                            else if (_Str.charAt(_Pos) == ',') state = EnumState.S22;
                            else { SetError(Err.RParenCommaExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S14:
                            if (_Str.charAt(_Pos) == 'l') state = EnumState.S15;
                            else { SetError(Err.TypeExceptions, _Pos); state = EnumState.Error; }
                            break;
                        case EnumState.S15:
                            if (_Str.charAt(_Pos) == 'o') state = EnumState.S16;
                            else { SetError(Err.TypeExceptions, _Pos); state = EnumState.Error; }
                            break;
                        case EnumState.S16:
                            if (_Str.charAt(_Pos) == 'a') state = EnumState.S17;
                            else { SetError(Err.TypeExceptions, _Pos); state = EnumState.Error; }
                            break;
                        case EnumState.S17:
                            if (_Str.charAt(_Pos) == 't') state = EnumState.S18;
                            else { SetError(Err.TypeExceptions, _Pos); state = EnumState.Error; }
                            break;
                        case EnumState.S18:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S18;
                            else if (_Str.charAt(_Pos) == ')') state = EnumState.S8;
                            else if (_Str.charAt(_Pos) == ',') state = EnumState.S22;
                            else { SetError(Err.RParenCommaExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S22:
                            if(Character.isLetter(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) state = EnumState.S9;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S22;
                            else { SetError(Err.UnrecognizedError, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S8:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S8;
                            else if (_Str.charAt(_Pos) == ':') state = EnumState.S23;
                            else { SetError(Err.ColonExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S23:
                            if (_Str.charAt(_Pos) == '\n') state = EnumState.S24;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S23;
                            else { SetError(Err.NewLineExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S24:
                            if (_Str.charAt(_Pos) == '\t') state = EnumState.S25;
                            else { SetError(Err.IndentExceptions, _Pos); state = EnumState.Error; }
                            break;

                        // ИСПРАВЛЕНИЕ 1: Поддержка return в начале тела функции
                        case EnumState.S25:
                            if (_Str.charAt(_Pos) == 'r') state = EnumState.S52;
                            else if (Character.isLetter(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) state = EnumState.S26;
                            else { SetError(Err.LetterExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S26:
                            if ((Character.isLetterOrDigit(_Str.charAt(_Pos))|| (_Str.charAt(_Pos) == '_'))){
                                state = EnumState.S26;
                            } else if(_Str.charAt(_Pos) == ' '){
                                state = EnumState.S26b;
                            } else if(_Str.charAt(_Pos) == '['){
                                state = EnumState.S27;
                            } else if(_Str.charAt(_Pos) == '='){
                                state = EnumState.S30;
                            } else{
                                SetError(Err.LetterDigitUnderLBracketAssign, _Pos);
                                state = EnumState.Error;
                            }
                            break;

                        case EnumState.S26b:
                            if(_Str.charAt(_Pos) == '[') state = EnumState.S27;
                            else if(_Str.charAt(_Pos) == ' ') state = EnumState.S26b;
                            else if(_Str.charAt(_Pos) == '=') state = EnumState.S30;
                            else{
                                SetError(Err.LBracketAssignExceptions, _Pos);
                                state = EnumState.Error;
                            }
                            break;

                        case EnumState.S27, EnumState.S27b:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S27b;
                            else if (Character.isLetterOrDigit(_Str.charAt(_Pos)) || _Str.charAt(_Pos) == '_') state = EnumState.S64;
                            else if (_Str.charAt(_Pos) == '-') state = EnumState.S62;
                            else if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S28;
                            else { SetError(Err.LetterDigitSignedException, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S62, EnumState.S62b:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S62b;
                            else if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S28;
                            else { SetError(Err.DigitExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S64:
                            if (Character.isLetterOrDigit(_Str.charAt(_Pos)) || _Str.charAt(_Pos) == '_') state = EnumState.S64;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S64b;
                            else if (_Str.charAt(_Pos) == ']') state = EnumState.S29;
                            else { SetError(Err.LetterDigitUnderRBracketExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S64b:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S64b;
                            else if (_Str.charAt(_Pos) == ']') state = EnumState.S29;
                            else { SetError(Err.RBracketExpected, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S28:
                            if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S28;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S28b;
                            else if (_Str.charAt(_Pos) == ']') state = EnumState.S29;
                            else { SetError(Err.DigitBracketExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S28b:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S28b;
                            else if (_Str.charAt(_Pos) == ']') state = EnumState.S29;
                            else { SetError(Err.RBracketExpected, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S29:
                            if (_Str.charAt(_Pos) == '=') state = EnumState.S30;
                            else if ((_Str.charAt(_Pos) == '+') || (_Str.charAt(_Pos) == '-') ||
                                    (_Str.charAt(_Pos) == '*') || (_Str.charAt(_Pos) == '/')) state = EnumState.S43;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S50;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S29;
                            else { SetError(Err.SignedNewLineExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S30:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S30;
                            else if ((Character.isLetterOrDigit(_Str.charAt(_Pos))|| (_Str.charAt(_Pos) == '_'))) state = EnumState.S31;
                            else if (_Str.charAt(_Pos) == '-') state = EnumState.S35;
                            else if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S36;
                            else { SetError(Err.LetterDigitSignedException, _Pos); state = EnumState.Error; }
                            break;

                        // ИСПРАВЛЕНИЕ 2: Операторы сразу после идентификатора (a*2)
                        case EnumState.S31:
                            if ((Character.isLetterOrDigit(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_'))) state = EnumState.S31;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S31b;
                            else if(_Str.charAt(_Pos) == '[') state = EnumState.S32;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S50;
                            else if (_Str.charAt(_Pos) == '+' || _Str.charAt(_Pos) == '-' || _Str.charAt(_Pos) == '*' || _Str.charAt(_Pos) == '/') state = EnumState.S43;
                            else { SetError(Err.LetterDigitUnderLBracketNewLine, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S31b:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S31b;
                            else if (_Str.charAt(_Pos) == '[') state = EnumState.S32;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S50;
                            else if (_Str.charAt(_Pos) == '+' || _Str.charAt(_Pos) == '-' || _Str.charAt(_Pos) == '*' || _Str.charAt(_Pos) == '/') state = EnumState.S43;
                            else if (_Str.charAt(_Pos) == '=') state = EnumState.S44;
                            else if (_Str.charAt(_Pos) == '!') state = EnumState.S45;
                            else if (_Str.charAt(_Pos) == '<') state = EnumState.S46;
                            else if (_Str.charAt(_Pos) == '>') state = EnumState.S48;
                            else { SetError(Err.LBracketAssignNewLineSignedExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S32, EnumState.S32b:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S32b;
                            else if (Character.isLetterOrDigit(_Str.charAt(_Pos)) || _Str.charAt(_Pos) == '_') state = EnumState.S63;
                            else if (_Str.charAt(_Pos) == '-') state = EnumState.S61;
                            else if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S33;
                            else { SetError(Err.LetterDigitSignedException, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S33:
                            if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S33;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S33b;
                            else if (_Str.charAt(_Pos) == ']') state = EnumState.S42;
                            else { SetError(Err.DigitBracketExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S33b:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S33b;
                            else if (_Str.charAt(_Pos) == ']') state = EnumState.S42;
                            else { SetError(Err.RBracketExpected, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S61, EnumState.S61b:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S61b;
                            else if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S33;
                            else { SetError(Err.DigitExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S63:
                            if (Character.isLetterOrDigit(_Str.charAt(_Pos)) || _Str.charAt(_Pos) == '_') state = EnumState.S63;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S63b;
                            else if (_Str.charAt(_Pos) == ']') state = EnumState.S42;
                            else { SetError(Err.LetterUnderSpaceRBracketExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S63b:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S63b;
                            else if (_Str.charAt(_Pos) == ']') state = EnumState.S42;
                            else { SetError(Err.RBracketExpected, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S42:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S42;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S60;
                            else if ((_Str.charAt(_Pos) == '+') || (_Str.charAt(_Pos) == '-') ||
                                    (_Str.charAt(_Pos) == '*') || (_Str.charAt(_Pos) == '/')) state = EnumState.S43;
                            else if (_Str.charAt(_Pos) == '=') state = EnumState.S44;
                            else if (_Str.charAt(_Pos) == '!') state = EnumState.S45;
                            else if (_Str.charAt(_Pos) == '<') state = EnumState.S46;
                            else if (_Str.charAt(_Pos) == '>') state = EnumState.S48;
                            else { SetError(Err.SignedExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S60:
                            if (_Str.charAt(_Pos) == '\t') state = EnumState.S51;
                            else { SetError(Err.IndentExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S46, EnumState.S48:
                            if (_Str.charAt(_Pos) == '=') state = EnumState.S43;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S47;
                            else { SetError(Err.AssignIndentExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S44, EnumState.S45:
                            if (_Str.charAt(_Pos) == '=') state = EnumState.S43;
                            else { SetError(Err.AssignExceptions, _Pos); state = EnumState.Error; }
                            break;

                        // ИСПРАВЛЕНИЕ 3: Операнд сразу после оператора без пробела (*2)
                        case EnumState.S43:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S47;
                            else if (Character.isLetter(_Str.charAt(_Pos)) || _Str.charAt(_Pos) == '_') state = EnumState.S31;
                            else if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S36;
                            else if (_Str.charAt(_Pos) == '-') state = EnumState.S35;
                            else { SetError(Err.IndentExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S47:
                            if ((Character.isLetter(_Str.charAt(_Pos))|| (_Str.charAt(_Pos) == '_'))) state = EnumState.S31;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S42;
                            else if (_Str.charAt(_Pos) == '-') state = EnumState.S35;
                            else if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S36;
                            else { SetError(Err.UnrecognizedError, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S35:
                            if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S36;
                            else { SetError(Err.DigitExceptions, _Pos); state = EnumState.Error; }
                            break;

                        // ИСПРАВЛЕНИЕ 4: Оператор сразу после числа (2+)
                        case EnumState.S36:
                            if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S36;
                            else if (_Str.charAt(_Pos) == '.') state = EnumState.S37;
                            else if ((_Str.charAt(_Pos) == 'e') || (_Str.charAt(_Pos) == 'E')) state = EnumState.S39;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S42;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S50;
                            else if (_Str.charAt(_Pos) == '+' || _Str.charAt(_Pos) == '-' || _Str.charAt(_Pos) == '*' || _Str.charAt(_Pos) == '/') state = EnumState.S43;
                            else { SetError(Err.UnrecognizedError, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S37:
                            if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S38;
                            else { SetError(Err.DigitExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S38:
                            if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S38;
                            else if ((_Str.charAt(_Pos) == 'e') || (_Str.charAt(_Pos) == 'E')) state = EnumState.S39;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S42;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S50;
                            else if (_Str.charAt(_Pos) == '+' || _Str.charAt(_Pos) == '-' || _Str.charAt(_Pos) == '*' || _Str.charAt(_Pos) == '/') state = EnumState.S43;
                            else { SetError(Err.UnrecognizedError, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S39:
                            if ((_Str.charAt(_Pos) == '+') || (_Str.charAt(_Pos) == '-')) state = EnumState.S40;
                            else if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S41;
                            else { SetError(Err.SignedDigitExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S40:
                            if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S41;
                            else { SetError(Err.DigitExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S41:
                            if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S41;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S42;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S50;
                            else if (_Str.charAt(_Pos) == '+' || _Str.charAt(_Pos) == '-' || _Str.charAt(_Pos) == '*' || _Str.charAt(_Pos) == '/') state = EnumState.S43;
                            else { SetError(Err.UnrecognizedError, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S50:
                            if (_Str.charAt(_Pos) == '\t') state = EnumState.S51;
                            else { SetError(Err.IndentExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S51:
                            if (_Str.charAt(_Pos) == '\n') state = EnumState.S59;
                            else if ((Character.isLetter(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) && !(_Str.charAt(_Pos) == 'r')) state = EnumState.S26;
                            else if (_Str.charAt(_Pos) == 'r') state = EnumState.S52;
                            else { SetError(Err.ControlIndentExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S52:
                            if ((Character.isLetter(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) && !(_Str.charAt(_Pos) == 'e')) state = EnumState.S26;
                            else if (_Str.charAt(_Pos) == 'e') state = EnumState.S53;
                            else { SetError(Err.ControlExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S53:
                            if ((Character.isLetter(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) && !(_Str.charAt(_Pos) == 't')) state = EnumState.S26;
                            else if (_Str.charAt(_Pos) == 't') state = EnumState.S54;
                            else { SetError(Err.ControlExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S54:
                            if ((Character.isLetter(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) && !(_Str.charAt(_Pos) == 'u')) state = EnumState.S26;
                            else if (_Str.charAt(_Pos) == 'u') state = EnumState.S55;
                            else { SetError(Err.ControlExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S55:
                            if ((Character.isLetter(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) && !(_Str.charAt(_Pos) == 'r')) state = EnumState.S26;
                            else if (_Str.charAt(_Pos) == 'r') state = EnumState.S56;
                            else { SetError(Err.ControlExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S56:
                            if ((Character.isLetter(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) && !(_Str.charAt(_Pos) == 'n')) state = EnumState.S26;
                            else if (_Str.charAt(_Pos) == 'n') state = EnumState.S57;
                            else { SetError(Err.ControlExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S57:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S58;
                            else { SetError(Err.IndentExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S58:
                            if ((Character.isLetterOrDigit(_Str.charAt(_Pos))|| (_Str.charAt(_Pos) == '_'))) state = EnumState.S65;
                            else if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S70;
                            else if (_Str.charAt(_Pos) == '-') state = EnumState.S71;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S58;
                            else { SetError(Err.UnrecognizedError, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S65:
                            if ((Character.isLetterOrDigit(_Str.charAt(_Pos))|| (_Str.charAt(_Pos) == '_'))) state = EnumState.S65;
                            else if (_Str.charAt(_Pos) == '[') state = EnumState.S66;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S77;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S59;
                            else { SetError(Err.LetterDigitUnderLBracketExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S66, EnumState.S66b:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S66b;
                            else if (Character.isLetterOrDigit(_Str.charAt(_Pos)) || _Str.charAt(_Pos) == '_') state = EnumState.S68;
                            else if (_Str.charAt(_Pos) == '-') state = EnumState.S85;
                            else if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S67;
                            else { SetError(Err.LetterDigitSignedException, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S68:
                            if (Character.isLetterOrDigit(_Str.charAt(_Pos)) || _Str.charAt(_Pos) == '_') state = EnumState.S68;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S68b;
                            else if (_Str.charAt(_Pos) == ']') state = EnumState.S69;
                            else { SetError(Err.LetterUnderSpaceRBracketExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S68b:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S68b;
                            else if (_Str.charAt(_Pos) == ']') state = EnumState.S69;
                            else { SetError(Err.RBracketExpected, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S85, EnumState.S85b:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S85b;
                            else if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S67;
                            else { SetError(Err.DigitExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S67:
                            if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S67;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S67b;
                            else if (_Str.charAt(_Pos) == ']') state = EnumState.S69;
                            else { SetError(Err.DigitBracketExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S67b:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S67b;
                            else if (_Str.charAt(_Pos) == ']') state = EnumState.S69;
                            else { SetError(Err.RBracketExpected, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S69:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S77;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S59;
                            else { SetError(Err.NewLineExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S77:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S77;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S59;
                            else if ((_Str.charAt(_Pos) == '+') || (_Str.charAt(_Pos) == '-') ||
                                    (_Str.charAt(_Pos) == '*') || (_Str.charAt(_Pos) == '/')) state = EnumState.S78;
                            else if (_Str.charAt(_Pos) == '=') state = EnumState.S79;
                            else if (_Str.charAt(_Pos) == '!') state = EnumState.S80;
                            else if (_Str.charAt(_Pos) == '<') state = EnumState.S81;
                            else if (_Str.charAt(_Pos) == '>') state = EnumState.S82;
                            else { SetError(Err.SignedExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S81, EnumState.S82:
                            if (_Str.charAt(_Pos) == '=') state = EnumState.S78;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S83;
                            else { SetError(Err.AssignIndentExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S80, EnumState.S79:
                            if (_Str.charAt(_Pos) == '=') state = EnumState.S78;
                            else { SetError(Err.AssignExceptions, _Pos); state = EnumState.Error; }
                            break;

                        // ИСПРАВЛЕНИЕ 5: Операнд сразу после оператора во 2+ строках
                        case EnumState.S78:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S83;
                            else if (Character.isLetterOrDigit(_Str.charAt(_Pos)) || _Str.charAt(_Pos) == '_') state = EnumState.S65;
                            else if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S70;
                            else if (_Str.charAt(_Pos) == '-') state = EnumState.S71;
                            else { SetError(Err.IndentExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S83:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S83;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S59;
                            else if (Character.isLetterOrDigit(_Str.charAt(_Pos)) || _Str.charAt(_Pos) == '_') state = EnumState.S65;
                            else if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S70;
                            else if (_Str.charAt(_Pos) == '-') state = EnumState.S71;
                            else { SetError(Err.LetterDigitSignedException, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S71:
                            if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S70;
                            else { SetError(Err.DigitExceptions, _Pos); state = EnumState.Error; }
                            break;

                        // ИСПРАВЛЕНИЕ 6: Оператор сразу после числа во 2+ строках
                        case EnumState.S70:
                            if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S70;
                            else if (_Str.charAt(_Pos) == '.') state = EnumState.S72;
                            else if ((_Str.charAt(_Pos) == 'e') || (_Str.charAt(_Pos) == 'E')) state = EnumState.S74;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S77;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S59;
                            else if (_Str.charAt(_Pos) == '+' || _Str.charAt(_Pos) == '-' || _Str.charAt(_Pos) == '*' || _Str.charAt(_Pos) == '/') state = EnumState.S78;
                            else { SetError(Err.UnrecognizedError, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S72:
                            if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S73;
                            else { SetError(Err.DigitExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S73:
                            if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S73;
                            else if ((_Str.charAt(_Pos) == 'e') || (_Str.charAt(_Pos) == 'E')) state = EnumState.S74;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S77;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S59;
                            else if (_Str.charAt(_Pos) == '+' || _Str.charAt(_Pos) == '-' || _Str.charAt(_Pos) == '*' || _Str.charAt(_Pos) == '/') state = EnumState.S78;
                            else { SetError(Err.UnrecognizedError, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S74:
                            if ((_Str.charAt(_Pos) == '+') || (_Str.charAt(_Pos) == '-')) state = EnumState.S75;
                            else if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S76;
                            else { SetError(Err.SignedDigitExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S75:
                            if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S76;
                            else { SetError(Err.DigitExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S76:
                            if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S76;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S77;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S59;
                            else if (_Str.charAt(_Pos) == '+' || _Str.charAt(_Pos) == '-' || _Str.charAt(_Pos) == '*' || _Str.charAt(_Pos) == '/') state = EnumState.S78;
                            else { SetError(Err.UnrecognizedError, _Pos); state = EnumState.Error; }
                            break;

                        // ИСПРАВЛЕНИЕ 7: Пропуск пробелов перед финальным переводом строки
                        case EnumState.S59:
                            if (_Str.charAt(_Pos) == '\n') state = EnumState.Final;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S59;
                            else { SetError(Err.NewLineExceptions, _Pos); state = EnumState.Error; }
                            break;
                    }
                }
                _Pos++;
            }
            return (state == EnumState.Final);
        }
    }
}

public class Analizator{
    public static void main(String[] args) {
        String[] tests = {
                "def f(x):\n\treturn x[1]\n ",
                "def test(a:int,b:float):\n\tx = a*2+5\n\treturn x\n\n ",
                "def get():\n\treturn data[10]\n\n ",
                "def foo():\n\ty = arr[-1]\n\treturn y\n\n ",
                "def bar(x:set):\n\tz = x[0]\n\treturn z\n\n "
        };
        for (int i = 0; i < tests.length; i++) {
            Result r = Result.CheckFunctionDef.Check(tests[i]);
            System.out.println( "Тест " + (i+1) + ": " + r.ErrMessage() + "(позиция " + r.ErrPosition() + ") ");
        }

        String test = "def get_state ( sym:int,set,fag):\n" +
                "\tcount =  data [-1]  * 10e+2 + data [ sym ] + data[ -12 ] \n" +
                "\tcount = count + flag \n" +
                "\treturn count[10] / 25  \n\n";

        Result r = Result.CheckFunctionDef.Check(test);
        System.out.println(r.ErrPosition() + ": " + r.ErrMessage());
    }
}