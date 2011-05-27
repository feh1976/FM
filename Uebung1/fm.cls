\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{fm}[2009/10/27 Ingo Sieverdingbeck] % 2011 überarbeitet von Philipp Dittmann
\LoadClass[a4paper]{scrartcl}

% -----------------------------------------------------------------------
% Required packages

\RequirePackage[ngerman]{babel}
\RequirePackage{amssymb}
\RequirePackage{epsfig}
\RequirePackage{graphicx}
\RequirePackage{moreverb}
\RequirePackage{parskip}


% -----------------------------------------------------------------------
% define page layout using typearea

\KOMAoptions{headinclude=true}
\KOMAoptions{footinclude=true}
\areaset{16cm}{27cm}
% -----------------------------------------------------------------------
% define page style
\pagestyle{plain}
\thispagestyle{plain}

% -----------------------------------------------------------------------
% Macro für das Abgabeblatt
\newcommand{\Abgabeblatt}[7]
          {\Arbblatt{#1}{#2}{#3}{#4}{#5}{#6}{#7}{\"Ubungsblatt}}

\newcommand{\grenzop}[3]{\mathop{#1}\limits^{#2}_{#3}}

\newcommand{\langrechtspfeil}[2]{\grenzop{\longrightarrow}{#1}{#2}}
\newcommand{\bob}[0]{\hspace*{\fill}$\Box$}

% -----------------------------------------------------------------------

\newcommand{\Arbblatt}[8]
{
\begin{tabular}[t]{lr}
  \begin{tabular}[t]{l}
    Formale Modellierung\hspace{20ex} SS 2011\\ \hspace{70ex} \\
    {\Huge\textsf{{#8} {#1}}} \hspace{12ex} \\[1.5ex]
    {\Large L\"osungsvorschlag} \\[1ex]
    {\Large Abgabe: {#2}} \\[1ex]
  \end{tabular}
  &
  \begin{tabular}[t]{l}
      {#4}\\\\
      {#5}\\
      {#6}\\
      {#7}\\
  \end{tabular} \\[2ex]
\end{tabular}\\
\rule{\linewidth}{1pt}
}

%%% Local Variables:
%%% mode: latex
%%% TeX-master: t
%%% End:

