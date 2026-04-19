import java.util.*;

enum Err{
    NoError,                                    // нет ошибок
    OutOfRange,                                 // выход за границы анализируемой строки
    SignedExceptions,                           // ожидается знак
    SignedDigitExceptions,                      // ожидается знак или цифра
    SignedNewLineExceptions,                    // ожидается знак или перенос строки
    SignedAssignNewLineExceptions,              // ожидается знак, '=' или перенос строки
    DigitExceptions,                            // ожидается цифра
    DigitRBracketExceptions,                    // ожидается цифра или ']'
    DigitDotEnewLineSignedExceptions,           // ожидается цифра, точка, e/E, перенос строки или знак
    DigitENewLineSignedExceptions,              // ожидается цифра, e/E, перенос строки или знак
    DigitNewLineSignedExceptions,               // ожидается цифра, перенос строки или знак
    LetterExceptions,                           // ожидается буква
    LetterUnderExceptions,                      // ожидается буква или нижнее подчёркивание
    LetterUnderDigitalExceptions,               // ожидается буква, нижнее подчёркивание или цифра
    LetterUnderRParenExceptions,                // ожидается буква, нижние подчёркивание или ')'
    LetterUnderSpaceRBracketExceptions,         // ожидается буква, нижние подчёркивание, отступ или '] '
    LetterDigitLParenExceptions,                // ожидается буква, цифра, нижнее подчёркивание или '('
    LetterDigitUnderLBracketAssign,             // ожидается буква, цифра, нижнее подчёркивание, '[' или '='
    LetterDigitUnderLBracketExceptions,         // ожидается буква, цифра, нижнее подчёркивание или '['
    LetterDigitUnderLBracketNewLineExceptions,  // ожидается буква, цифра, нижнее подчёркивание, '[' или перенос строки
    LetterDigitUnderRParenColonCommaExceptions, // ожидается буква, цифра, нижнее подчёркивание, ')', ':' или ','
    LetterDigitUnderSignedException,            // ожидается буква, цифра, нижнее подчёркивание или '-'
    LetterDigitUnderRBracketExceptions,         // ожидается буква, цифра, нижнее подчёркивание или ']'
    LBracketAssignExceptions,                   // ожидается '[' или '='
    LBracketAssignNewLineSignedExceptions,      // ожидается '[', '=', перенос строки или знак
    ColonRParenExceptions,                      // ожидается ':' или ')'
    IndentDigitExceptions,                      // ожидается отступ или буква
    TypeExceptions,                             // ожидается буква из зарезервированных слов: (int, float, set)
    TypeIndentExceptions,                       // ожидается буква из зарезервированных слов: (int, float, set) или отступ
    ControlExceptions,                          // ожидается буква из зарезервированного слова: return
    ControlNewLineExceptions,                   // ожидается буква из зарезервированного слова: return или перенос строки
    ControlIndentExceptions,                    // ожидается буква из зарезервированного слова: return или отступ
    RParenCommaExceptions,                      // ожидается ')' или ','
    IndentColonExceptions,                      // ожидается отступ или ':'
    LParenExceptions,                           // ожидается '('
    RParenExceptions,                           // ожидается ')'
    ColonExceptions,                            // ожидается ':'
    CommaExceptions,                            // ожидается ','
    LBracketExceptions,                         // ожидается '['
    RBracketExpected,                           // ожидается ']'
    NewLineExceptions,                          // ожидается перенос строки
    IndentExceptions,                           // ожидается отступ
    TabExceptions,                              // ожидается tab
    AssignExceptions,                           // ожидается '='
    AssignIndentExceptions,                     // ожидается '=' или отступ
    IntLongExceptions,                          // число содержит больше 10 цифр
    InvalidNumber,                              // ? некорректное число
    UnexpectedChar,                             // неожиданный символ
    UnrecognizedError                           // неизвестная ошибка
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
            case Err.DigitRBracketExceptions: return  "ожидается цифра или ']' ";
            case Err.LetterExceptions: return  "ожидается буква ";
            case Err.LetterUnderExceptions: return  "ожидается буква или нижнее подчёркивание ";
            case Err.LetterUnderDigitalExceptions: return  "ожидается буква, нижнее подчёркивание или цифра ";
            case Err.LetterUnderRParenExceptions: return  "ожидается буква, нижние подчёркивание или ')' ";
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
            case Err.TabExceptions: return "ожидается tab ";
            case Err.AssignExceptions: return  "ожидается '=' ";
            case Err.AssignIndentExceptions: return  "ожидается '=' или отступ ";
            case Err.IntLongExceptions: return  "число содержит больше 10 цифр ";
            case Err.InvalidNumber: return  "? некорректное число ";
            case Err.UnexpectedChar: return  "неожиданный символ ";
            case Err.UnrecognizedError: return  "неизвестная ошибка ";
            case Err.LetterDigitLParenExceptions: return  "ожидается буква, цифра, нижнее подчёркивание или '(' ";
            case Err.LetterDigitUnderRParenColonCommaExceptions: return  "ожидается буква, цифра, нижнее подчёркивание, ')', ':' или ',' ";
            case Err.ColonRParenExceptions: return  "ожидается ':' или ')' ";
            case Err.LetterDigitUnderLBracketAssign: return  "ожидается буква, цифра, нижнее подчёркивание, '[' или '=' ";
            case Err.LBracketAssignExceptions: return  "ожидается '[' или '=' ";
            case Err.LetterDigitUnderLBracketNewLineExceptions: return  "ожидается буква, цифра, нижнее подчёркивание, '[' или перенос строки ";
            case Err.LBracketAssignNewLineSignedExceptions: return  "ожидается '[', '=', перенос строки или знак ";
            case Err.LetterDigitUnderSignedException: return  "ожидается буква, цифра, нижнее подчёркивание или '-'";
            case Err.LetterDigitUnderRBracketExceptions: return  "ожидается буква, цифра, нижнее подчёркивание или ']' ";
            case Err.LetterDigitUnderLBracketExceptions: return  "ожидается буква, цифра, нижнее подчёркивание или '[' ";
            case Err.SignedNewLineExceptions: return  "ожидается знак или перенос строки ";
            case Err.SignedAssignNewLineExceptions: return "ожидается знак, '=' или перенос строки ";
            case Err.DigitDotEnewLineSignedExceptions: return "ожидается точка, e/E, перенос строки или знак ";
            case Err.DigitENewLineSignedExceptions: return "ожидается цифра, e/E, перенос строки или знак ";
            case Err.DigitNewLineSignedExceptions: return "ожидается цифра, перенос строки или знак ";
            case Err.ControlNewLineExceptions: return "ожидается буква из зарезервированного слова: return или перенос строки ";
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
                    if (state == EnumState.S59) {
                        state = EnumState.Final;
                    }
                    else {
                        SetError(Err.OutOfRange, _Pos - 1); state = EnumState.Error;
                    }
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
                            if (_Str.charAt(_Pos) == 'f')  state = EnumState.S4;
                            else { SetError(Err.LetterExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S4:
                            if (_Str.charAt(_Pos) == ' ') state =  EnumState.S5;
                            else { SetError(Err.IndentExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S5:
                            if (Character.isLetter(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_'))  state = EnumState.S6;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S5;
                            else { SetError(Err.LetterUnderExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S6:
                            if (Character.isLetterOrDigit (_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) state = EnumState.S6;
                            else if (_Str.charAt(_Pos) == '(') state = EnumState.S7;
                            else if (_Str.charAt(_Pos) == ' ') state =  EnumState.S6b;
                            else { SetError(Err.LetterDigitLParenExceptions,_Pos); state = EnumState.Error; }
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
                            else { SetError(Err.LetterUnderRParenExceptions,_Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S9:
                            if (Character.isLetterOrDigit(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) state = EnumState.S9;
                            else if (_Str.charAt(_Pos) == ')') state =  EnumState.S8;
                            else if (_Str.charAt(_Pos) == ':') state = EnumState.S10;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S9b;
                            else if (_Str.charAt( _Pos) == ',') state = EnumState.S22;
                            else { SetError(Err.LetterDigitUnderRParenColonCommaExceptions, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.LetterUnderExceptions, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.TabExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S25:
                            if (_Str.charAt(_Pos) == 'r') state = EnumState.S52;
                            else if (Character.isLetter(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) state = EnumState.S26;
                            else { SetError(Err.LetterUnderExceptions, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.LetterDigitUnderSignedException, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.DigitRBracketExceptions, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.SignedAssignNewLineExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S30:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S30;
                            else if ((Character.isLetterOrDigit(_Str.charAt(_Pos))|| (_Str.charAt(_Pos) == '_'))) state = EnumState.S31;
                            else if (_Str.charAt(_Pos) == '-') state = EnumState.S35;
                            else if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S36;
                            else { SetError(Err.LetterDigitUnderSignedException, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S31:
                            if ((Character.isLetterOrDigit(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_'))) state = EnumState.S31;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S31b;
                            else if(_Str.charAt(_Pos) == '[') state = EnumState.S32;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S50;
                            else if (_Str.charAt(_Pos) == '+' || _Str.charAt(_Pos) == '-' || _Str.charAt(_Pos) == '*' || _Str.charAt(_Pos) == '/') state = EnumState.S43;
                            else { SetError(Err.LetterDigitUnderLBracketNewLineExceptions, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.LetterDigitUnderSignedException, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S33:
                            if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S33;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S33b;
                            else if (_Str.charAt(_Pos) == ']') state = EnumState.S42;
                            else { SetError(Err.DigitRBracketExceptions, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.LetterDigitUnderRBracketExceptions, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.SignedAssignNewLineExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S60:
                            if (_Str.charAt(_Pos) == '\t') state = EnumState.S51;
                            else { SetError(Err.TabExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S46, EnumState.S48:
                            if (_Str.charAt(_Pos) == '=') state = EnumState.S43;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S47;
                            else { SetError(Err.AssignExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S44, EnumState.S45:
                            if (_Str.charAt(_Pos) == '=') state = EnumState.S43;
                            else { SetError(Err.AssignExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S43:
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S47;
                            else if (Character.isLetter(_Str.charAt(_Pos)) || _Str.charAt(_Pos) == '_') state = EnumState.S31;
                            else if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S36;
                            else if (_Str.charAt(_Pos) == '-') state = EnumState.S35;
                            else { SetError(Err.LetterDigitUnderSignedException, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S47:
                            if ((Character.isLetter(_Str.charAt(_Pos))|| (_Str.charAt(_Pos) == '_'))) state = EnumState.S31;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S42;
                            else if (_Str.charAt(_Pos) == '-') state = EnumState.S35;
                            else if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S36;
                            else { SetError(Err.LetterDigitUnderSignedException, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S35:
                            if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S36;
                            else { SetError(Err.DigitExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S36:
                            if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S36;
                            else if (_Str.charAt(_Pos) == '.') state = EnumState.S37;
                            else if ((_Str.charAt(_Pos) == 'e') || (_Str.charAt(_Pos) == 'E')) state = EnumState.S39;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S42;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S50;
                            else if (_Str.charAt(_Pos) == '+' || _Str.charAt(_Pos) == '-' || _Str.charAt(_Pos) == '*' || _Str.charAt(_Pos) == '/') state = EnumState.S43;
                            else { SetError(Err.DigitDotEnewLineSignedExceptions, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.DigitENewLineSignedExceptions, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.DigitNewLineSignedExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S50:
                            if (_Str.charAt(_Pos) == '\t') state = EnumState.S51;
                            else { SetError(Err.TabExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S51:
                            if (_Str.charAt(_Pos) == '\n') state = EnumState.S59;
                            else if ((Character.isLetter(_Str.charAt(_Pos)) || (_Str.charAt(_Pos) == '_')) && !(_Str.charAt(_Pos) == 'r')) state = EnumState.S26;
                            else if (_Str.charAt(_Pos) == 'r') state = EnumState.S52;
                            else { SetError(Err.ControlNewLineExceptions, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.LetterDigitUnderSignedException, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.LetterDigitUnderSignedException, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.DigitRBracketExceptions, _Pos); state = EnumState.Error; }
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

                        case EnumState.S77: // Взять другую ошибку, не писать в ошибки про пробел (необязательный)!
                            if (_Str.charAt(_Pos) == ' ') state = EnumState.S77;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S59;
                            else if ((_Str.charAt(_Pos) == '+') || (_Str.charAt(_Pos) == '-') ||
                                    (_Str.charAt(_Pos) == '*') || (_Str.charAt(_Pos) == '/')) state = EnumState.S78;
                            else if (_Str.charAt(_Pos) == '=') state = EnumState.S79;
                            else if (_Str.charAt(_Pos) == '!') state = EnumState.S80;
                            else if (_Str.charAt(_Pos) == '<') state = EnumState.S81;
                            else if (_Str.charAt(_Pos) == '>') state = EnumState.S82;
                            else { SetError(Err.SignedAssignNewLineExceptions, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.LetterDigitUnderSignedException, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S71:
                            if (Character.isDigit(_Str.charAt(_Pos))) state = EnumState.S70;
                            else { SetError(Err.DigitExceptions, _Pos); state = EnumState.Error; }
                            break;

                        case EnumState.S70:
                            if ((Character.isDigit(_Str.charAt(_Pos)))) state = EnumState.S70;
                            else if (_Str.charAt(_Pos) == '.') state = EnumState.S72;
                            else if ((_Str.charAt(_Pos) == 'e') || (_Str.charAt(_Pos) == 'E')) state = EnumState.S74;
                            else if (_Str.charAt(_Pos) == ' ') state = EnumState.S77;
                            else if (_Str.charAt(_Pos) == '\n') state = EnumState.S59;
                            else if (_Str.charAt(_Pos) == '+' || _Str.charAt(_Pos) == '-' || _Str.charAt(_Pos) == '*' || _Str.charAt(_Pos) == '/') state = EnumState.S78;
                            else { SetError(Err.DigitDotEnewLineSignedExceptions, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.DigitENewLineSignedExceptions, _Pos); state = EnumState.Error; }
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
                            else { SetError(Err.DigitNewLineSignedExceptions, _Pos); state = EnumState.Error; }
                            break;

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
                "\tcount =  data [ -1 ]  * 10e+2 + data [ sym ] + data[ -12 ] \n" +
                "\tcount = count + flag \n" +
                "\treturn count[ 10 ] / 25  \n\n";

        Result r = Result.CheckFunctionDef.Check(test);
        System.out.println(r.ErrPosition() + ": " + r.ErrMessage());
    }
}
/*
//====ГРАФ ДЛЯ КОПИРОВАНИЕ ПРИ ИЗМНЕНЕНИИ КОДА====
digraph G {
    node [shape=circle];
    1 [shape=Mdiamond];
    84 [shape=doublecircle];

    1 -> 2 [label="d"];
    2 -> 3 [label="e"];
    3 -> 4 [label="f"];
    4 -> 5 [label="space"];
    5 -> 6 [label="a|...|z|_"];
    5 -> 5 [label="space"];
    6 -> 6 [label="a|...|z|_|0|...|9"];
    6 -> 7 [label="("];
    7 -> 8 [label=")"];
    7 -> 9 [label="a|...|z|_"];
    9 -> 8 [label=")"];
    9 -> 9 [label="a|...|z|_|0|...|9"];
    9 -> 10 [label=":"];
    10 -> 11 [label="i"];
    11 -> 12 [label="n"];
    12 -> 13 [label="t"];
    13 -> 8 [label=")"];
    10 -> 14 [label="f"];
    14 -> 15 [label="l"];
    15 -> 16 [label="o"];
    16 -> 17 [label="a"];
    17 -> 18 [label="t"];
    18 -> 8 [label=")"];
    10 -> 19 [label="s"];
    19 -> 20 [label="e"];
    20 -> 21 [label="t"];
    21 -> 8 [label=")"];
    13 -> 22 [label=","];
    18 -> 22 [label=","];
    21 -> 22 [label=","];
    9 -> 22 [label=","];
    22 -> 9 [label="a|...|z|_"];
    22 -> 22 [label="space"];
    8 -> 8 [label="space"];
    8 -> 23 [label=":"];
    23 -> 24 [label="enter"];
    23 -> 23 [label="space"];
    24 -> 25 [label="tab"];
    25 -> 26 [label="a|...|z|_"];
    26 -> 26 [label="a|...|z|_|0|...|9"];
    26 -> 27 [label="["];
    27 -> 28 [label="0|...|9"];
    27 -> 62 [label="-"];
    62 -> 28 [label="0|...|9"];
    27 -> 64 [label="a|...|z|_|0|...|9"];
    64 -> 64 [label="a|...|z|_|0|...|9"];
    64 -> 29 [label="]"];
    28 -> 28 [label="0|...|9"];
    28 -> 29 [label="]"];
    26 -> 30 [label="="];
    29 -> 30 [label="="];
    30 -> 31 [label="a|...|z|_"];
    31 -> 31 [label="a|...|z|_|0|...|9"];
    31 -> 32 [label="["];
    32 -> 61 [label="-"];
    61 -> 33 [label="0|...|9"];
    32 -> 63 [label="a|...|z|_|0|...|9"];
    63 -> 63 [label="a|...|z|_|0|...|9"];
    63 -> 42 [label="]"];
    32 -> 33 [label="0|...|9"];
    33 -> 33 [label="0|...|9"];
    33 -> 42 [label="]"];
    30 -> 35 [label="-"];
    30 -> 36 [label="0|...|9"];
    35 -> 36 [label="0|...|9"];
    36 -> 36 [label="0|...|9"];
    36 -> 37 [label="."];
    37 -> 38 [label="0|...|9"];
    38 -> 38 [label="0|...|9"];
    36 -> 39 [label="e|E"];
    38 -> 39 [label="e|E"];
    39 -> 40 [label="+|-"];
    39 -> 41 [label="0|...|9"];
    40 -> 41 [label="0|...|9"];
    41 -> 41 [label="0|...|9"];
    36 -> 42 [label="space"];
    38 -> 42 [label="space"];
    41 -> 42 [label="space"];
    42 -> 42 [label="space"];
    42 -> 60 [label="enter"];
    60 -> 51 [label="tab"];
    42 -> 43 [label="+|-|*|/"];
    42 -> 44 [label="="];
    44 -> 43 [label="="];
    42 -> 45 [label="!"];
    45 -> 43 [label="="];
    42 -> 46 [label="<"];
    46 -> 43 [label="="];
    46 -> 47 [label="space"];
    42 -> 48 [label=">"];
    48 -> 43 [label="="];
    48 -> 47 [label="space"];
    43 -> 47 [label="space"];
    47 -> 31 [label="a|...|z|_"];
    47 -> 42 [label="space"];
    47 -> 35 [label="-"];
    47 -> 36 [label="0|...|9"];
    31 -> 50 [label="enter"];
    36 -> 50 [label="enter"];
    38 -> 50 [label="enter"];
    41 -> 50 [label="enter"];
    50 -> 51 [label="tab"];
    51 -> 59 [label="enter"];
    51 -> 26 [label="a|...|q|q|...|z|_"];
    51 -> 52 [label="r"];
    52 -> 53 [label="e"];
    53 -> 54 [label="t"];
    54 -> 55 [label="u"];
    55 -> 56 [label="r"];
    56 -> 57 [label="n"];
    57 -> 58 [label="space"];
    58 -> 65 [label="a|...|z|_"];
    58 -> 70 [label="0|...|9"];
    58 -> 71 [label="-"];
    65 -> 65 [label="a|...|z|_|0|...|9"];
    65 -> 66 [label="["];
    65 -> 77 [label="space"];
    65 -> 59 [label="enter"];
    66 -> 67 [label="0|...|9"];
    66 -> 68 [label="a|...|z|_|0|...|9"];
    67 -> 67 [label="0|...|9"];
    67 -> 69 [label="]"];
    68 -> 68 [label="a|...|z|_|0|...|9"];
    68 -> 69 [label="]"];
    69 -> 77 [label="space"];
    69 -> 59 [label="enter"];
    70 -> 70 [label="0|...|9"];
    70 -> 72 [label="."];
    70 -> 74 [label="e|E"];
    70 -> 77 [label="space"];
    70 -> 59 [label="enter"];
    71 -> 70 [label="0|...|9"];
    72 -> 73 [label="0|...|9"];
    73 -> 73 [label="0|...|9"];
    73 -> 74 [label="e|E"];
    73 -> 77 [label="space"];
    73 -> 59 [label="enter"];
    74 -> 75 [label="+|-"];
    74 -> 76 [label="0|...|9"];
    75 -> 76 [label="0|...|9"];
    76 -> 76 [label="0|...|9"];
    76 -> 77 [label="space"];
    76 -> 59 [label="enter"];
    77 -> 78 [label="+|-|*|/"];
    77 -> 79 [label="="];
    77 -> 80 [label="!"];
    77 -> 81 [label="<"];
    77 -> 82 [label=">"];
    78 -> 83 [label="space"];
    79 -> 78 [label="="];
    80 -> 78 [label="="];
    81 -> 78 [label="="];
    81 -> 83 [label="space"];
    82 -> 78 [label="="];
    82 -> 83 [label="space"];
    83 -> 65 [label="a|...|z|_"];
    83 -> 70 [label="0|...|9"];
    83 -> 71 [label="-"];

    7 -> 7 [label="space"];
    30 -> 30 [label="space"];
    10 -> 10 [label="space"];
    21 -> 21 [label="space"];
    13 -> 13 [label="space"];
    18 -> 18 [label="space"];

    52 -> 26 [label="a|...|e|e|...|z|_"];
    53 -> 26 [label="a|...|d|d|...|z|_"];
    54 -> 26 [label="a|...|t|t|...|z|_"];
    55 -> 26 [label="a|...|q|q|...|z|_"];
    56 -> 26 [label="a|...|m|m|...|z|_"];

    59 -> 84 [label="enter"];
    66 -> 85 [label="-"];
    85 -> 67 [label="0|...|9"];
    29 -> 43 [label="+|-|*|/"];
    29 -> 50 [label="enter"];
    29 -> 29 [label="space"];

    6 -> "6b" [label="space"];
    "6b" -> "6b" [label="space"];
    "6b" -> 7 [label="("];

    9 -> "9b" [label="space"];
    "9b" -> "9b" [label="space"];
    "9b" -> 10 [label=":"];
    "9b" -> 8 [label=")"];

    26 -> "26b" [label="space"];
    "26b" -> "26b" [label="space"];
    "26b" -> 27 [label="["];
    "26b" -> 30 [label="="];

    31 -> "31b" [label="space"];
    "31b" -> "31b" [label="space"];
    "31b" -> 32 [label="["];
    "31b" -> 50 [label="enter"];
    "31b" -> 46 [label="<"];
    "31b" -> 43 [label="+|-|*|/"];
    "31b" -> 44 [label="="];
    "31b" -> 48 [label=">"];
    "31b" -> 45 [label="!"];

    27 -> "27b" [label="space"];
    "27b" -> "27b" [label="space"];
    "27b" -> 64 [label="a|...|z|_|0|...|9"];
    "27b" -> 62 [label="-"];
    "27b" -> 28 [label="0|...|9"];

    62 -> "62b" [label="space"];
    "62b" -> "62b" [label="space"];
    "62b" -> 28 [label="0|...|9"];

    28 -> "28b" [label="space"];
    "28b" -> "28b" [label="space"];
    "28b" -> 29 [label="]"];

    64 -> "64b" [label="space"];
    "64b" -> "64b" [label="space"];
    "64b" -> 29 [label="]"];

    32 -> "32b" [label="space"];
    "32b" -> "32b" [label="space"];
    "32b" -> 63 [label="a|...|z|_|0|...|9"];
    "32b" -> 61 [label="-"];
    "32b" -> 33 [label="0|...|9"];

    61 -> "61b" [label="space"];
    "61b" -> "61b" [label="space"];
    "61b" -> 33 [label="0|...|9"];

    33 -> "33b" [label="space"];
    "33b" -> "33b" [label="space"];
    "33b" -> 42 [label="]"];

    63 -> "63b" [label="space"];
    "63b" -> "63b" [label="space"];
    "63b" -> 42 [label="]"];

    58 -> 58 [label="space"];

    66 -> "66b" [label="space"];
    "66b" -> "66b" [label="space"];
    "66b" -> 68 [label="a|...|z|_|0|...|9"];
    "66b" -> 85 [label="-"];
    "66b" -> 67 [label="0|...|9"];

    85 -> "85b" [label="space"];
    "85b" -> "85b" [label="space"];
    "85b" -> 67 [label="0|...|9"];

    67 -> "67b" [label="space"];
    "67b" -> "67b" [label="space"];
    "67b" -> 69 [label="]"];

    68 -> "68b" [label="space"];
    "68b" -> "68b" [label="space"];
    "68b" -> "69" [label="]"];

    77 -> 77 [label="space"];

    78 -> 65 [label="a|...|z|_"];
    78 -> 70 [label="0|...|9"];
    78 -> 71 [label="-"];

    77 -> 59 [label="enter"];
}
 */